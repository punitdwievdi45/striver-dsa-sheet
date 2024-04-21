package designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {

    List<User> userArrayList = new ArrayList<>();

    public void addUser(User user){
        userArrayList.add(user);
    }

    public User getUser(int index){
       return userArrayList.get(index);
    }

    public MyIterator getIterator(){
        return new MyIteratorImpl(userArrayList);
    }
}
