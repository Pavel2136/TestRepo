package task3;

public class Counter implements Runnable {
    private int counter1 = 0;
    private int counter2 = 0;


    @Override
    public void run() {
        synchronized (this) {
            while (counter1 <= 10 || counter2 <= 10) {
                try {
                    System.out.println(counter1 + " == " + counter2);
                    if (counter1 == counter2) {
                        System.out.println(counter1 + " is equal " + counter2);
                    } else if (counter1 > counter2){
                        System.out.println(counter1 + " is bigger than " + counter2);
                    }else {
                        System.out.println(counter2 + " is less than " + counter1);
                    }
                    counter1++;
                    Thread.sleep(100);
                    counter2++;
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
