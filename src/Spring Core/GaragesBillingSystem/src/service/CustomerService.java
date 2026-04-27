package service;

import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps =
                conn.prepareStatement("INSERT INTO customers (name, phone) VALUES (?, ?)");

        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> list = new ArrayList<>();

        Connection conn = DbConfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM customers");

        while (rs.next()) {
            list.add(new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone")
            ));
        }

        rs.close();
        st.close();
        conn.close();

        return list;
    }

    public Customer getCustomersBasesOnNum(String number) throws SQLException {
        return getCustomer(number);
    }

    static Customer getCustomer(String number) throws SQLException {
        Customer customer = null; // FIX: no default constructor

        Connection conn = DbConfig.getConnection();
        PreparedStatement ps =
                conn.prepareStatement("SELECT * FROM customers WHERE phone = ?");

        ps.setString(1, number);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            customer = new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone")
            );
        }

        rs.close();
        ps.close();
        conn.close();

        return customer;
    }
}