package task4b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SearchEngine {

    private int[][] matrix;
    private int maxInMatrix;
    private long timeOfMultiThreadingSearch;
    private long timeOfSingleThreadingSearch;
    private List<Future<Integer>> futureList;

    public SearchEngine(int[][] matrix) {
        this.matrix = matrix;
        futureList = new ArrayList<>();
    }

    public long getTimeOfMultiThreadingSearch() {
        return timeOfMultiThreadingSearch;
    }

    public long getTimeOfSingleThreadingSearch() {
        return timeOfSingleThreadingSearch;
    }

    public List<Future<Integer>> getFutureList() {
        return futureList;
    }

    public int getMaxElementInMatrixMultiThreading()
            throws InterruptedException, ExecutionException {

        Callable<Integer>[] arrFinders = new Finder[matrix.length];
        long start = System.nanoTime();
        runFinders(arrFinders);
        maxInMatrix = findMaxOfAllThreads(futureList);
        long finish = System.nanoTime();
        timeOfMultiThreadingSearch = (finish - start) / 1_000_000;
        return maxInMatrix;
    }

    private void runFinders(Callable<Integer>[] arrFinders) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < arrFinders.length; i++) {
            arrFinders[i] = new Finder(i);
            futureList.add(es.submit(arrFinders[i]));
        }
        es.shutdown();
    }

    private int findMaxInRow(int row) throws InterruptedException {
        int maxInRow = matrix[row][0];
        for (int j = 1; j < matrix[row].length; j++) {
            TimeUnit.MILLISECONDS.sleep(1);
            if (maxInRow < matrix[row][j]) {
                maxInRow = matrix[row][j];
            }
        }
        return maxInRow;
    }

    private int findMaxOfAllThreads(List<Future<Integer>> futureList)
            throws ExecutionException, InterruptedException {
        int max = futureList.get(0).get();
        for (Future<Integer> future : futureList) {
            if (future.get() > max) {
                max = future.get();
            }
        }
        return max;
    }

    public int getMaxElementInMatrixSingleThreading() throws InterruptedException {
        long start = System.nanoTime();
        int maxInRow =  matrix[0][0];
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            maxInRow = findMaxInRow(i);
            if (maxInRow > max) {
                max = maxInRow;
            }
        }
        long finish = System.nanoTime();
        timeOfSingleThreadingSearch = (finish - start) / 1_000_000;
        return max;
    }

    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int)(Math.random() * 100001);
            }
        }
        return matrix;
    }

    private class Finder implements Callable<Integer> {
        private int threadId;
        private int maxOfThread;

        public Finder(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public Integer call() throws Exception {
            maxOfThread = findMaxInRow(threadId);
            return maxOfThread;
        }
    }
}
