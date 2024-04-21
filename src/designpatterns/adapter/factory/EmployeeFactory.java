package designpatterns.adapter.factory;

public class EmployeeFactory {

    public static Employee getInstance(EmployeeAdapterFactory employeeAdapterFactory){
        return employeeAdapterFactory.createInstance();
    }
}
