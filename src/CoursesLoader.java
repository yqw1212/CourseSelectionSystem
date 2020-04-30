import java.io.FileNotFoundException;
import java.io.IOException;

public interface CoursesLoader {
    CourseDB loadCourseDB(String filename,TeacherDB teacherDB) throws FileNotFoundException, IOException;
}
