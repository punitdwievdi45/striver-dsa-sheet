package designpatterns.observer;

public class Subscriber implements Observer{

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notified(String title) {
        System.out.println("Hey "+this.name+" new video uploaded by "+ title);
    }
}
