package SemaphoreConsumerproducer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> queue;
    Semaphore producer;
    Semaphore consumer;


    public Consumer(Queue<Object> queue, Semaphore consumer, Semaphore producer) {
        this.queue = queue;
        this.consumer = consumer;
        this.producer = producer;
    }
    public void run() {
        while(true) {
            try {
                consumer.acquire();

                    System.out.println("Consumer is running");
                    queue.remove();

                producer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
