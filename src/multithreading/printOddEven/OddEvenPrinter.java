package multithreading.printOddEven;

public class OddEvenPrinter {

    private int number = 1;
    private int numberOfThreads;
    private int numberInSequence;

    public OddEvenPrinter(int numberOfThreads, int numberInSequence) {
        this.numberOfThreads = numberOfThreads;
        this.numberInSequence = numberInSequence;
    }

    public void printOddEven(int result) throws InterruptedException {
        synchronized (this) {
            while ((number < numberInSequence)) {
                while (number % 2 != result) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " " + number++);
                notifyAll();
            }
        }
    }
}
