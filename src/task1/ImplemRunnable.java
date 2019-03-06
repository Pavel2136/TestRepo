package task1;

public class ImplemRunnable implements Runnable{
    private Thread t;
    private String name;

    public ImplemRunnable() {
        this.t = Thread.currentThread();
        this.name = t.getName();
    }

    public ImplemRunnable(String name) {
        this.t = Thread.currentThread();
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(this.name);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " завершен");
    }
}
