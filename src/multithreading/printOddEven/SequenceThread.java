package multithreading.printOddEven;

public class SequenceThread implements Runnable{

    private OddEvenPrinter oddEvenPrinter;
    private int result;

    public SequenceThread(OddEvenPrinter oddEvenPrinter, int result) {
        this.oddEvenPrinter = oddEvenPrinter;
        this.result = result;
    }

    @Override
    public void run() {
        try {
            oddEvenPrinter.printOddEven(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
