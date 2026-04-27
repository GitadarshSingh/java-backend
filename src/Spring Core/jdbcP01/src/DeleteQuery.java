import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteQuery {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd","root","Adarsh@1234$");

            Statement statement = con.createStatement();

            String query="DELETE from student where id=4";

            int update = statement.executeUpdate(query);

            System.out.println("Inserted" +update+ "rows");





        }catch(Exception e){
            e.printStackTrace();

        }

    }
}
