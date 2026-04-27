import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcP01 {
    public static void main(String[] args) {
        // 1.Load Driver Class
        // 2. get connection
        // 3.create statement
        // 4.String query
        // 5.ResultSet rs
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver"); ->Load driver

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd","root","Adarsh@1234$");

            Statement statement = con.createStatement();

            String query="select * from student";

            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getInt("id")+"|"+
                                   rs.getString("stdname")+"|"+
                                   rs.getInt("age")
                );
            }



        }catch(Exception e){
            e.printStackTrace();

        }
    }
}