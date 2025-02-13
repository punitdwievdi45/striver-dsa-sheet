package multithreading.producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private static final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);


    public static void main(String[] args) {
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                    consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }

    private static void consume() throws InterruptedException {
        while (true) {
            Thread.sleep(2000);
            Integer consumed = blockingQueue.take();
            System.out.println("Consumed : " + consumed);
        }
    }

    private static void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(2000);
            int producer = random.nextInt(100);
            blockingQueue.put(producer);
            System.out.println("Produced : " + producer);
        }
    }
}
