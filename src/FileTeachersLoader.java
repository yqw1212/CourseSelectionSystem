import java.io.*;
import java.util.StringTokenizer;

public class FileTeachersLoader implements TeachersLoader {
    PrintWriter stdErr = new PrintWriter(System.err,true);
    TeacherDB teacherDB = new TeacherDB();
    @Override
    public TeacherDB loadTeacherDB(String filename) throws FileNotFoundException, IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

            String line = bufferedReader.readLine();
            while (line != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, "_");
                if (stringTokenizer.countTokens()==3) {
                    teacherDB.addTeacher(
                            new Teacher(stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken()));
                    line = bufferedReader.readLine();
                }else {
                    throw new DataFormatException(line);
                }
            }
        }catch (FileNotFoundException f) {
            stdErr.println("The file does not exist");
        }catch (DataFormatException d){
            stdErr.println("The file contains malformed data:");
        }
        return teacherDB;
    }
}
