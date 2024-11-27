class PrintQueue {
    private final String[] queue;
    private int front = 0;
    private int rear = 0;

    public PrintQueue(int capacity) {
        this.queue = new String[capacity];
    }

    public synchronized void addDocument(String document) throws InterruptedException {
        while ((rear + 1) % queue.length == front) { // Queue is full
            wait();
        }
        queue[rear] = document;
        rear = (rear + 1) % queue.length; // Move rear
        notify(); // Notify consumer
    }

    public synchronized String removeDocument() throws InterruptedException {
        while (front == rear) { // Queue is empty
            wait();
        }
        String document = queue[front];
        front = (front + 1) % queue.length; // Move front
        notify(); // Notify producer
        return document;
    }
}

class Producer extends Thread {
    private final PrintQueue printQueue;

    public Producer(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        try {
            int documentNumber = 1;
            while (true) {
                printQueue.addDocument("Document " + documentNumber++);
                Thread.sleep((int) (Math.random() * 1000)); // Simulate document creation
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private final PrintQueue printQueue;

    public Consumer(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String document = printQueue.removeDocument();
                System.out.println("Consumer printed: " + document);
                Thread.sleep((int) (Math.random() * 1500)); // Simulate printing time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class PrintingSystem {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue(10); // Queue capacity of 10

        Producer producer = new Producer(printQueue);
        Consumer consumer = new Consumer(printQueue);

        producer.start();
        consumer.start();
    }
}
