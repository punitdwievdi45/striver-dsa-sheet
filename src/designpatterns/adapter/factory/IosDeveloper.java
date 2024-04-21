package designpatterns.adapter.factory;

public class IosDeveloper implements Employee{
    @Override
    public int salary() {
        return 100000;
    }

    @Override
    public String name() {
        return "I am IOS Developer";
    }
}
