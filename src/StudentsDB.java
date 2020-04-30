import java.util.ArrayList;
import java.util.Iterator;

public class StudentsDB implements Iterable<Student> {
    private ArrayList<Student> students;
    StudentsDB(){
        students = new ArrayList<Student>();
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public int getNumber(){
        return students.size();
    }
    @Override
    public Iterator<Student> iterator() {
        return this.students.iterator();
    }
}
