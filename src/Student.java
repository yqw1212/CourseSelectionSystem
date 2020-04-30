import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person{
    private int grade;
    private int class_;
    //ArrayList<Course> courses;
    HashSet<Course> courses;
    Student(String name, String code, String academy,int grade,int class_) {
        super(name, code, academy);
        this.grade = grade;
        this.class_ = class_;
        courses = new HashSet<Course>();
        //courses = new ArrayList<Course>();
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    public String toStringCourses(){
        String str = "";
        for(Course c:courses){
            str = str + c+"\n";
        }
        return str;
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public int getGrade() {
        return grade;
    }
    public int getClass_() {
        return class_;
    }

    @Override
    public String toString() {
        return super.toString()+"_"+getGrade()+"_"+getClass_();
    }
}
