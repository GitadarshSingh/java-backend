import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollInsensitive {
    public static void main(String[] args) {

        try{
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd","root","Adarsh@1234$");

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                      ResultSet.CONCUR_READ_ONLY);

            String query="select * from student";

            System.out.println("-----------------Read Only-----------------------------");

          // SCROLL TYPE_FORWARD_ONLY, CONCURRENT_TYPE -- default
            ResultSet rs = statement.executeQuery(query);

            rs.first();
            System.out.println("first row"+rs.getInt("id"));
            System.out.println("first row"+rs.getString("stdname"));

            rs.last();
            System.out.println("Last Row"+rs.getInt("id"));
            System.out.println("Last Row"+rs.getString("stdname"));

            //Particular row par jana hai
            rs.absolute(2);
            System.out.println("Second Row: " +rs.getInt("id"));
            System.out.println("Second Row: "+rs.getString("stdname"));





        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
