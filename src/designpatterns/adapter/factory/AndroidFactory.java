package designpatterns.adapter.factory;

public class AndroidFactory extends EmployeeAdapterFactory{
    @Override
    Employee createInstance() {
        return new AndroidDeveloper();
    }
}
