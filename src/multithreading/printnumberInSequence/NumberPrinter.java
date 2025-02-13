package multithreading.printnumberInSequence;

public class NumberPrinter {

    int number = 1;
    private  int noOfThread;
    private   int totalNumberInSequence;

    public NumberPrinter(int noOfThread, int totalNumberInSequence) {
        this.noOfThread = noOfThread;
        this.totalNumberInSequence = totalNumberInSequence;
    }

    public void printNumbers(int result) throws InterruptedException {

        synchronized (this) {
            while (number < totalNumberInSequence) {
                while (number % noOfThread != result) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " " + number++);
                notifyAll();
            }
        }
    }
}
