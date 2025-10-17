import java.sql.*;
import java.util.*;

public class ProductCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "password";
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false);
            while (true) {
                System.out.println("1.Insert 2.Display 3.Update 4.Delete 5.Exit");
                int ch = sc.nextInt();
                if (ch == 1) {
                    PreparedStatement ps = con.prepareStatement("INSERT INTO Product VALUES(?,?,?,?)");
                    System.out.println("Enter ID Name Price Quantity");
                    ps.setInt(1, sc.nextInt());
                    ps.setString(2, sc.next());
                    ps.setDouble(3, sc.nextDouble());
                    ps.setInt(4, sc.nextInt());
                    ps.executeUpdate();
                    con.commit();
                } else if (ch == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM Product");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " " + rs.getInt(4));
                    }
                } else if (ch == 3) {
                    PreparedStatement ps = con.prepareStatement("UPDATE Product SET Price=?, Quantity=? WHERE ProductID=?");
                    System.out.println("Enter Price Quantity ID");
                    ps.setDouble(1, sc.nextDouble());
                    ps.setInt(2, sc.nextInt());
                    ps.setInt(3, sc.nextInt());
                    ps.executeUpdate();
                    con.commit();
                } else if (ch == 4) {
                    PreparedStatement ps = con.prepareStatement("DELETE FROM Product WHERE ProductID=?");
                    System.out.println("Enter ID");
                    ps.setInt(1, sc.nextInt());
                    ps.executeUpdate();
                    con.commit();
                } else if (ch == 5) {
                    break;
                }
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
