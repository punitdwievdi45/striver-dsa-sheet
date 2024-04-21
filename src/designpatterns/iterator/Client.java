package designpatterns.iterator;

public class Client {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        User user1 = new User("1", "A");
        User user2 = new User("2", "B");
        User user3 = new User("3", "C");
        User user4 = new User("4", "D");

        userManagement.addUser(user1);
        userManagement.addUser(user2);
        userManagement.addUser(user3);
        userManagement.addUser(user4);

        MyIterator myIterator = userManagement.getIterator();
        while (myIterator.hasNext()) {
            User user = (User) myIterator.next();
            System.out.println(user.getUserName());
        }

    }
}
