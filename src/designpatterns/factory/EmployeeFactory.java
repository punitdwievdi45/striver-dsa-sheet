package designpatterns.factory;

public class EmployeeFactory {

    public static  Employee getInstance(String empType){
        return switch (empType) {
            case "Android Developer" -> new AndroidDeveloper();
            case "IOS Developer" -> new IosDeveloper();
            case "Web Developer" -> new WebDeveloper();
            default -> null;
        };
    }
}
