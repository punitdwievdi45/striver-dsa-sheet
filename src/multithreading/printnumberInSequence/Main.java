package multithreading.printnumberInSequence;

public class Main {

    private static final int noOfThread = 3;
    private static final int totalNumberInSequence = 20;

    public static void main(String[] args) {

        NumberPrinter numberPrinter = new NumberPrinter(noOfThread, totalNumberInSequence);
        Thread t1 = new Thread(new SequenceThread(numberPrinter, 1));
        Thread t2 = new Thread(new SequenceThread(numberPrinter, 2));
        Thread t3 = new Thread(new SequenceThread(numberPrinter, 0));
        t1.start();
        t2.start();
        t3.start();
    }
}
