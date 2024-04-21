package designpatterns.prototype;

public class DatabaseConnection implements Cloneable{

    private String url;
    private String userName;
    private String password;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DatabaseConnection{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", book=" + book +
                '}';
    }

    public void loadConnection() throws InterruptedException {
        System.out.println("Connection established with database");
       // Thread.sleep(5000);
       // Thread.sleep(5000);
    }

     /*shallow cloning
             In shallow cloning if there is any references then when you will make the changes in reference
    then it will effect the clone object as well because the clone reference is pointing to the main object.*/
   /* @Override
    public Object clone() {
        try {
            return super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original

        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }*/


    // deep cloning
    /*
             In Deep cloning if there is any references then when you will make the changes in reference
    then it will not effect the clone object  because the clone reference will point to the new object and the implementation
   is below .*/
    @Override
    public DatabaseConnection clone() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.setPassword(this.password);
        databaseConnection.setUrl(this.url);
        databaseConnection.setUserName(this.userName);
        Book newBook = new Book();
        newBook.setId(this.book.getId());
        newBook.setName(this.book.getName());
        databaseConnection.setBook(newBook);

        return databaseConnection;
        // TODO: copy mutable state here, so the clone can't change the internals of the original

    }
}
