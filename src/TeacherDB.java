import java.util.ArrayList;
import java.util.Iterator;

public class TeacherDB implements Iterable<Teacher>{
    private ArrayList<Teacher> teachers;
    TeacherDB(){
        teachers = new ArrayList<Teacher>();
    }
    public Teacher getTeacher(String name){
        Teacher teacher = null;
        for(Teacher t:teachers){
            if(t.getName().equals(name))
                teacher = t;
        }
        return teacher;
    }
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    @Override
    public Iterator<Teacher> iterator() {
        return this.teachers.iterator();
    }
}
