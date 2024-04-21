package designpatterns.observer;

/*Observer Design Pattern : It's a behavorial design pattern'
In this when subject changes the state all it's dependent objects notified the changes'
One to many relation*/

public class Client {
    public static void main(String[] args) {
        Youtube youtube = new Youtube();
        Observer subscriber1 = new Subscriber("Punit");
        Observer subscriber2 = new Subscriber("Amit");
        Observer subscriber3 = new Subscriber("Dhoni");

        youtube.subscribe(subscriber1);
        youtube.subscribe(subscriber2);
        youtube.subscribe(subscriber3);

        youtube.unsubscribe(subscriber1);


        youtube.newVideoUploaded("Java Interview");
        youtube.newVideoUploaded("java Techie");

    }
}
