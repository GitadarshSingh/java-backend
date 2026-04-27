import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PST {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd", "root", "Adarsh@1234$");

            String query = "INSERT INTO student(id,stdname,age) values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,5);
            pst.setString(2,"Radha");
            pst.setInt(3,29);

            pst.executeUpdate();
            System.out.println("------------INSERTED-------------------");

            con.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
