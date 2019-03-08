package task1;

public class TestMyThread {

    public static void main(String[] args) {
        ImplemRunnable testImplemRunnable = new ImplemRunnable("Поток через Runnable"); //запуск потока через
        // имплементацию Runnable
        testImplemRunnable.run();

        new ExtendsThread("Поток через Thread"); // запуск через расширение класса Thread

    }
}
