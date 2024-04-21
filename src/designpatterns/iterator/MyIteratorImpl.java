package designpatterns.iterator;

import java.util.List;

public class MyIteratorImpl implements MyIterator {

    private int position = 0;
    private List<User> list;
    private int length;

    public MyIteratorImpl(List<User> userArrayList) {
        this.list = userArrayList;
        this.length = userArrayList.size();
    }

    @Override
    public boolean hasNext() {
        if (position >= length) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        User user = list.get(position);
        position += 1;
        return user;
    }
}
