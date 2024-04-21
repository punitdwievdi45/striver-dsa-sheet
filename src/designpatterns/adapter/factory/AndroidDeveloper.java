package designpatterns.adapter.factory;

import designpatterns.adapter.factory.Employee;

public class AndroidDeveloper implements Employee {
    @Override
    public int salary() {
        return 50000;
    }

    @Override
    public String name() {
        return "I am android developer";
    }
}
