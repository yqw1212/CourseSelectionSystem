public class HTMLFormatter implements SelectionFormatter {
    private static HTMLFormatter htmlFormatter = null;
    private HTMLFormatter(){}
    public static HTMLFormatter getSingletonInstance(){
        if(htmlFormatter==null)
            htmlFormatter = new HTMLFormatter();
        return htmlFormatter;
    }
    @Override
    public String formatterSelections(StudentsDB studentsDB) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>").append("\n");
        stringBuffer.append("<body>").append("\n");
        stringBuffer.append("<center><h2>Course selection results</h2></center>").append("\n");
        for(Student student:studentsDB){
            stringBuffer.append("<h3>studentName:").append(student.getName())
                    .append(" Code:").append(student.getCode())
                    .append(" Academy:").append(student.getAcademy()).append("</h3>").append("\n");
            for(Course c:student.getCourses())
                stringBuffer.append(c).append("<br>");
        }
        stringBuffer.append("</body>").append("\n");
        stringBuffer.append("</html>").append("\n");
        return stringBuffer.toString();
    }
}
