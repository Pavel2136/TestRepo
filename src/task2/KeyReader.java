package task2;

import java.io.IOException;

public class KeyReader implements Runnable {

    @Override
    public void run() {
        int i;
        try {
            i = System.in.read();
            for (i = 0; i == 10;) {
                i = System.in.read();
            }
            System.out.println("Выполнение остановлено пользователем");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Ошибка ввода данных");
        }
    }
}
