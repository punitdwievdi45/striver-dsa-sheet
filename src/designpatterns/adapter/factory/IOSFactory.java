package designpatterns.adapter.factory;

public class IOSFactory extends EmployeeAdapterFactory{
    @Override
    Employee createInstance() {
        return new IosDeveloper();
    }
}
