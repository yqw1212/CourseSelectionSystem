public class Person {
    private String name;
    private String code;
    private String academy;
    Person(String name,String code,String academy){
        this.name = name;
        this.code = code;
        this.academy = academy;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public String getAcademy() {
        return academy;
    }

    @Override
    public String toString() {
        return getName()+"_"+getCode()+"_"+getAcademy();
    }
}
