package task2;

public class Spam implements Runnable {
    private int[] time;
    private String[] msg;

    public Spam() {
        this.time = new int[]{5000, 10000, 1000, 3000, 500};
        this.msg = new String[]{"Первое сообщение", "Второе сообщение", "Привет", "Хэллоу", "Собака"};
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= time.length; i++) {
                if (i == time.length) {
                    System.exit(0);
                }
                System.out.println(msg[i]);
                Thread.sleep(time[i]);
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        (new Thread(new KeyReader())).start();

        (new Thread(new Spam())).start();

    }
}