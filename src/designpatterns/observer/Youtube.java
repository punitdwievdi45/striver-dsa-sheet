package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Youtube implements Subject{

    List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
        subscribers.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        subscribers.remove(ob);
    }

    @Override
    public void newVideoUploaded(String title) {
        for (Observer ob : this.subscribers){
            ob.notified(title);
        }
    }
}
