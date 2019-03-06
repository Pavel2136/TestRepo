package task2;

public class SpamTest{

    public static void main(String[] args) {

        (new Thread(new KeyReader())).start();

        (new Thread(new Spam())).start();

        part2Main();
    }

    private static void part2Main() {
        try {
            Thread.sleep(5000);
            System.out.println("Let's imagine that Enter was pressed");
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

