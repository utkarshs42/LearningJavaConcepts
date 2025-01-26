package SemaphoreConsumerproducer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> queue = new ConcurrentLinkedQueue<Object>();
        Semaphore producer = new Semaphore(6);
        Semaphore consumer = new Semaphore(0);

        Producer producer1 = new Producer(queue,consumer,producer);
        Producer producer2 = new Producer(queue,consumer,producer);
        Producer producer3 = new Producer(queue,consumer,producer);
        Producer producer4 = new Producer(queue,consumer,producer);
        Producer producer5 = new Producer(queue,consumer,producer);
        Producer producer6 = new Producer(queue,consumer,producer);

        Consumer consumer1 = new Consumer(queue,consumer,producer);
        Consumer consumer2 = new Consumer(queue,consumer,producer);
        Consumer consumer3 = new Consumer(queue,consumer,producer);
        Consumer consumer4 = new Consumer(queue,consumer,producer);
        Consumer consumer5 = new Consumer(queue,consumer,producer);

        Thread p1 = new Thread(producer1);
        Thread p2 = new Thread(producer2);
        Thread p3 = new Thread(producer3);
        Thread p4 = new Thread(producer4);
        Thread p5 = new Thread(producer5);
        Thread p6 = new Thread(producer6);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();

        Thread c1 = new Thread(consumer1);
        Thread c2 = new Thread(consumer2);
        Thread c3 = new Thread(consumer3);
        Thread c4 = new Thread(consumer4);
        Thread c5 = new Thread(consumer5);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();


    }
}
