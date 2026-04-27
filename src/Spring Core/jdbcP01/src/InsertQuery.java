import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertQuery {
   public static void main(String[] args) {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");

           Connection con = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/mystd","root","Adarsh@1234$");

           Statement statement = con.createStatement();

           String query="INSERT into student (id, stdname, age) values(4,'Ankit',21)";

           int update = statement.executeUpdate(query);

           System.out.println("Inserted" +update+ "rows");





       }catch(Exception e){
           e.printStackTrace();

       }

    }
}
