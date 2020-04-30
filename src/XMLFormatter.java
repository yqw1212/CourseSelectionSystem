public class XMLFormatter implements SelectionFormatter {
    private static XMLFormatter xmlFormatter = null;
    private XMLFormatter(){}
    public static XMLFormatter getSingletonInstance(){
        if(xmlFormatter == null){
            xmlFormatter = new XMLFormatter();
        }
        return xmlFormatter;
    }
    @Override
    public String formatterSelections(StudentsDB studentsDB) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<students>").append("\n");
        for(Student student:studentsDB) {
            stringBuffer.append("<student>").append("\n");
            stringBuffer.append("<info> name:").append(student.getName())
                    .append(" Code:").append(student.getCode())
                    .append(" Academy:").append(student.getAcademy()).append("</info>").append("\n");
            for(Course c:student.getCourses())
                stringBuffer.append("<course>").append(c).append("</course>").append("\n");
            stringBuffer.append("</student>").append("\n");
        }
        stringBuffer.append("</students>").append("\n");
        return stringBuffer.toString();
    }
}
