package DaoPattern;
public class Use1 {
    public static void main(String arr[]) {
        StudentDao imp = new StudentDaoImple();
        Student student = imp.getStudent(101);
        System.out.println("Roll No: " + student.getRoll() + "       Name: " + student.getName());
    }
}
