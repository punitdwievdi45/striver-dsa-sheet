package designpatterns.prototype;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.setUserName("postgres");
        databaseConnection.setUrl("127.0.0.1:8080");
        databaseConnection.setPassword("1234");
        Book book = new Book();
        book.setId(1);
        book.setName("Java");
        databaseConnection.setBook(book);
        System.out.println(databaseConnection);

        //databaseConnection.loadConnection();
       // databaseConnection.setPassword("0000");

        DatabaseConnection cloneDatabaseConnection = databaseConnection.clone();
        databaseConnection.getBook().setId(2);
        databaseConnection.setPassword("0000");
        System.out.println("Original Data : " + databaseConnection);
        System.out.println("Clone Data : " + cloneDatabaseConnection); // you can see at line 19 i have made the changes to book object but its printing the old one only
        databaseConnection.loadConnection();
        // System.out.println(databaseConnection);
    }
}
