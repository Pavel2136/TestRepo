package task1;

public class ExtendsThread extends Thread{
    private String name;

    public ExtendsThread() {
        super("task1.ExtendsThread");
        this.name = ExtendsThread.currentThread().getName();
        start();
    }

    public ExtendsThread(String name) {
        super("task1.ExtendsThread");
        this.name = name;
        start();
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
