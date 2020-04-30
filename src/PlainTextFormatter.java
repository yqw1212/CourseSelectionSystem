public class PlainTextFormatter implements SelectionFormatter {
    private static PlainTextFormatter plainTextFormatter=null;
    private PlainTextFormatter(){}
    public static PlainTextFormatter getSingletonInstance(){
        if (plainTextFormatter==null)
            plainTextFormatter = new PlainTextFormatter();
        return plainTextFormatter;
    }
    public String formatterSelections(StudentsDB studentsDB) {
        StringBuffer stringBuffer = new StringBuffer();
        for(Student student:studentsDB) {
            stringBuffer.append("-------------------------------------------------").append("\n");
            stringBuffer.append(student).append("\n");
            stringBuffer.append(student.toStringCourses());
        }
        return stringBuffer.toString();
    }
}
