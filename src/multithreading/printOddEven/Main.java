package multithreading.printOddEven;


public class Main {
    private static final int numberOfThread = 2;
    private static final int numberInSequence = 10;
    public static void main(String[] args) {

        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter(numberOfThread,numberInSequence);
        Thread t1 = new Thread(new SequenceThread(oddEvenPrinter,1));
        Thread t2 = new Thread(new SequenceThread(oddEvenPrinter,0));
        t1.start();
        t2.start();

    }
}
