import java.sql.*;

public class StudentDAO {
    Connection con;
    public StudentDAO() throws Exception {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","password");
    }
    public void insert(Student s) throws Exception {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Student VALUES(?,?,?,?)");
        ps.setInt(1, s.getId());
        ps.setString(2, s.getName());
        ps.setString(3, s.getDept());
        ps.setInt(4, s.getMarks());
        ps.executeUpdate();
    }
    public void display() throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Student");
        while (rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
        }
    }
    public void update(int id, int marks) throws Exception {
        PreparedStatement ps = con.prepareStatement("UPDATE Student SET Marks=? WHERE StudentID=?");
        ps.setInt(1, marks);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
    public void delete(int id) throws Exception {
        PreparedStatement ps = con.prepareStatement("DELETE FROM Student WHERE StudentID=?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
