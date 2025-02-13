package multithreading.printnumberInSequence;

public class SequenceThread implements Runnable{

    NumberPrinter numberPrinter;

    int result;

    public SequenceThread(NumberPrinter numberPrinter, int result) {
        this.numberPrinter = numberPrinter;
        this.result = result;
    }

    @Override
    public void run() {
        try {
            numberPrinter.printNumbers(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
