package UnitTest.newpackage;
import java.util.List;
public class StudentDaoImple implements StudentDao
{

    @Override
    public void deleteStudent(Student s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Student> getAllStudent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Student getStudent(int i) {
        return new Student("Imran Khan",1);
    }

    @Override
    public void updateStudent(Student s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
