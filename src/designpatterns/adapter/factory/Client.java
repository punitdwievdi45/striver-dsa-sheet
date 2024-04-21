package designpatterns.adapter.factory;

/*Abstact factory Design Patter is similar to factory design pattern
It provides the concept of factory of factories. It has one more layer to create the object*/

public class Client {
    public static void main(String[] args) {
        Employee employee = EmployeeFactory.getInstance(new AndroidFactory());
        if (employee instanceof AndroidDeveloper) {
            System.out.println(employee.name());
            System.out.println(employee.salary());
        }
        Employee employee1 = EmployeeFactory.getInstance(new IOSFactory());
        if (employee1 instanceof IosDeveloper){
            System.out.println(employee1.name());
            System.out.println(employee1.salary());
        }
    }
}
