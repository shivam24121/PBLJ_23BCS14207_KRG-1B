import java.sql.*;
public class FetchEmployees{
    public static void main(String[] args) {
        final String url="jdbc:mysql://localhost:3306/cu";
        final String username="root";
        final String password="";

        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,password);
            String query="SELECT id, name, salary, department FROM employees";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(query);
            
            while(rs.next()) {
                System.out.println("ID:"+ rs.getInt("id"));
                System.out.println("Name:"+ rs.getString("name"));
                System.out.println("Salary:"+ rs.getDouble("salary"));
                System.out.println("Department:"+ rs.getString("department"));
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

