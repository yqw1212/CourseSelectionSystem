import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Course {
    private String name;
    private String code;
    private Teacher teacher;

    private HashMap<String,Integer> jie;
    private ArrayList<Integer> weeks;
    private String classroom;

    private HashSet<Student> students;

    Course(String name,String code,String classroom,String jie,String weeks,Teacher teacher){
        students = new HashSet<Student>();
        this.name = name;
        this.code = code;
        this.classroom = classroom;
        setJie(jie);//以“星期几-第几节,星期几-第几节,......”的形式传入
        setWeeks(weeks);//以“1,2,3,4,5,......”的形式传入
        this.teacher = teacher;
    }
    public void addStudent(Student s){
        students.add(s);
    }
    public HashSet<Student> getStudents(){
        return students;
    }
    public void setWeeks(String str) {
        weeks = new ArrayList<Integer>();
        StringTokenizer stringTokenizer = new StringTokenizer(str,",");
        while (stringTokenizer.hasMoreTokens()){
            weeks.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
    }

    private void setJie(String str){
        this.jie = new HashMap<String,Integer>();
        StringTokenizer stringTokenizer = new StringTokenizer(str,",");
        while (stringTokenizer.hasMoreTokens()){
            String s = stringTokenizer.nextToken();
            StringTokenizer tokenizer = new StringTokenizer(s,"-");
            jie.put(tokenizer.nextToken(),Integer.parseInt(tokenizer.nextToken()));
        }
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public String getClassroom() {
        return classroom;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public String toStringJie(){
        String str = "";
        for(String s:jie.keySet()){
            str = str + s+"-"+jie.get(s)+",";
        }
        return str;
    }
    public String toStringWeeks(){
        String str = "";
        for (Integer i :weeks){
            str = str+i+",";
        }
        return str;
    }
    @Override
    public String toString() {
        return getCode()+"_"+getName()+"_"+getTeacher().getName()+"_"+toStringJie()+"_"+toStringWeeks()+"_"+getClassroom();
    }
}
