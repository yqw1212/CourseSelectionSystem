import java.io.FileNotFoundException;
import java.io.IOException;

public interface TeachersLoader {
    TeacherDB loadTeacherDB(String filename) throws FileNotFoundException, IOException;
}
