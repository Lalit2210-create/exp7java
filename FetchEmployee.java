import java.sql.*;

public class FetchEmployee {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "password";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Employee");
            while (rs.next()) {
                System.out.println(rs.getInt("EmpID") + " " + rs.getString("Name") + " " + rs.getDouble("Salary"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
