import java.io.*;
import java.util.StringTokenizer;

public class FileCoursesLoader implements CoursesLoader {
    PrintWriter stdErr = new PrintWriter(System.err,true);
    CourseDB courseDB = new CourseDB();
    @Override
    public CourseDB loadCourseDB(String filename,TeacherDB teacherDB) throws FileNotFoundException, IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filename)));

            String line = bufferedReader.readLine();
            while (line != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, "_");
                if(stringTokenizer.countTokens()==6) {
                    courseDB.addCourse(
                            new Course(stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(),
                                    stringTokenizer.nextToken(), stringTokenizer.nextToken(),
                                    teacherDB.getTeacher(stringTokenizer.nextToken())));
                    line = bufferedReader.readLine();
                }else {
                    throw new DataFormatException(line);
                }
            }
        }catch (FileNotFoundException f){
            stdErr.println("The file does not exist");
        }catch (DataFormatException d){
            stdErr.println("The file contains malformed data:");
        }

        return courseDB;
    }
}
