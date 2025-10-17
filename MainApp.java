import java.util.*;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        while (true) {
            System.out.println("1.Add 2.View 3.Update 4.Delete 5.Exit");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("Enter ID Name Dept Marks");
                Student s = new Student(sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
                dao.insert(s);
            } else if (ch == 2) {
                dao.display();
            } else if (ch == 3) {
                System.out.println("Enter ID and New Marks");
                dao.update(sc.nextInt(), sc.nextInt());
            } else if (ch == 4) {
                System.out.println("Enter ID");
                dao.delete(sc.nextInt());
            } else if (ch == 5) {
                break;
            }
            sc.close();
        }
    }
}
