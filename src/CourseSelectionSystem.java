import java.io.*;
import java.util.StringTokenizer;

public class CourseSelectionSystem {
    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdOut = new PrintWriter(System.out,true);
    private static PrintWriter stdErr = new PrintWriter(System.err,true);

    private SelectionFormatter selectionFormatter;
    private CourseDB courseDB;
    private TeacherDB teacherDB;
    private StudentsDB studentsDB;

    public static void main(String[] args) {
        try {
            TeacherDB teacherDB = (new FileTeachersLoader()).loadTeacherDB("teachers.dat");
            CourseDB coursesDB = (new FileCoursesLoader()).loadCourseDB("courses.dat",teacherDB);
            CourseSelectionSystem courseSelectionSystem = new CourseSelectionSystem(teacherDB,coursesDB);
            courseSelectionSystem.run();
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            stdErr.println("The file does not exist");
            System.exit(1);
        } catch (IOException e) {
//            e.printStackTrace();
            stdErr.println("读入错误");
            System.exit(1);
        } catch (DataFormatException  e) {
            stdErr.println("Invalid format");
        }catch (InterruptedException i){
            stdErr.println("Time wrong");
        }

    }
    CourseSelectionSystem(TeacherDB teacherDB,CourseDB courseDB){
        this.teacherDB = teacherDB;
        this.courseDB = courseDB;
        studentsDB = new StudentsDB();
    }
    public void run() throws IOException, DataFormatException, InterruptedException {
        int choice = getChoice();
        while (choice!=0) {
            if(choice==1) {
                for (Course c : courseDB) {
                    System.out.println(c);
                }
            }else if (choice==2){
                Student student=null;
                System.out.println("请输入学生姓名,学号,学院,年级,班级按照如下格式:");
                System.out.println("Tim_20196666_software_1_1915");
                String line = stdIn.readLine();
                StringTokenizer stringTokenizer =  new StringTokenizer(line,"_");
                if(stringTokenizer.countTokens()==5) {
                    while (stringTokenizer.hasMoreTokens()) {
                        student = new Student(stringTokenizer.nextToken(), stringTokenizer.nextToken(),
                                stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken()),
                                Integer.parseInt(stringTokenizer.nextToken()));
                    }
                }else{
                    throw new DataFormatException(line);
                }
                select(student);
                studentsDB.addStudent(student);
            }else if(choice==3) {
                this.selectionFormatter = PlainTextFormatter.getSingletonInstance();
                display();
            }else if (choice==4){
                show();
            }else if(choice==5){
                this.selectionFormatter = HTMLFormatter.getSingletonInstance();
                writeFile();
            }else if(choice==6){
                this.selectionFormatter = XMLFormatter.getSingletonInstance();
                writeFile();
            }
            Thread.sleep(300);
            choice = getChoice();
        }
    }
    public int getChoice() throws IOException {
        int in;
        while (true) {
            try {
                stdErr.println("CourseSelectionSystem");
                stdErr.println("[0]Exit");
                stdErr.println("[1]Show courses");
                stdErr.println("[2]Select courses");
                stdErr.println("[3]Show courses selection results");
                stdErr.println("[4]Show students list of per course");
                stdErr.println("[5]Write course selection results as HTML file");
                stdErr.println("[6]Write course selection results as XML file");
                in = Integer.parseInt(stdIn.readLine());//!
                if (in >= 0 && in <= 5) {
                    break;
                } else {
                    stdErr.println("Invalid choice: " + in);
                }
            }catch (NumberFormatException  nfe){
                stdErr.println(nfe);
            }
        }
        return in;
    }
    public void writeFile() throws IOException {
        System.out.println("请输入文件名");
        String fileName = stdIn.readLine();
        PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))));
        printWriter.println(this.selectionFormatter.formatterSelections(studentsDB));
        printWriter.close();
    }
    public void display(){
        if(studentsDB.getNumber()==0){
            System.out.println("It is empty");
        }else {
            System.out.println(this.selectionFormatter.formatterSelections(studentsDB));
        }
    }
    private void select(Student student) throws IOException {
        System.out.println("请输入课程的编码选课,输入空字符停止");
        String line = stdIn.readLine();
        while (line.length()!=0){
            if (courseDB.getCourse(line)!=null) {
                courseDB.getCourse(line).addStudent(student);//
                student.addCourse(courseDB.getCourse(line));//
            }else {
                stdErr.println("The course you inputted doesn't exist, please input the right code of course");
            }
            line = stdIn.readLine();
        }
        System.out.println("您所选课程是:");
        System.out.println(student.toStringCourses());
    }
    public void show(){
        for(Course c : courseDB){
            System.out.println("-----------------------------");
            System.out.println(c);
            for(Student s : c.getStudents()){
                System.out.println(s);
            }
        }
    }
}
