package task3;

public class CounterTest {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t = new Thread(counter);
        t.setName("Thread 1");

        Thread t2 = new Thread(counter);
        t2.setName("Thread 2");

        t.start();
        t2.start();
    }
}
