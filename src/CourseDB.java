import java.util.ArrayList;
import java.util.Iterator;

public class CourseDB implements Iterable<Course>{
    ArrayList<Course> courses;
    CourseDB(){
        courses = new ArrayList<Course>();
    }
    public Course getCourse(String code){
        Course course = null;
        for(Course c: courses){
            if(c.getCode().equals(code))
                course = c;
        }
        return course;
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public void removeCourse(Course course){
        courses.remove(course);
    }
    @Override
    public Iterator<Course> iterator() {
        return this.courses.iterator();
    }
}
