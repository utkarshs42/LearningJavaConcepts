package SemaphoreConsumerproducer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Object> queue;
    Semaphore producer;
    Semaphore consumer;

    public Producer(Queue<Object> queue, Semaphore consumer, Semaphore producer) {
        this.queue = queue;
        this.consumer = consumer;
        this.producer = producer;
    }

    @Override
    public void run() {
         while(true){
             try {
                 producer.acquire();

                     System.out.println("Producing");
                     queue.add(new Object());

                 consumer.release();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }

         }
    }
}
