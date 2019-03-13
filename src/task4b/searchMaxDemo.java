package task4b;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class searchMaxDemo  {

    public static void main(String[] args) throws
            InterruptedException, ExecutionException {

        int[][] matrix = SearchEngine.createRandomMatrix(4,100);

        SearchEngine se = new SearchEngine(matrix);

        System.out.println("*****Test of search process in Multithreading*****");
        System.out.println("MAx element in matrix: " + se.getMaxElementInMatrixMultiThreading());
        System.out.println("Time of Multithreading search is " + se.getTimeOfMultiThreadingSearch());

        System.out.println();

        System.out.println("*****Test of Single Thread Search*****");
        System.out.println("Max element in matrix " + se.getMaxElementInMatrixSingleThreading());
        System.out.println("Time of single Thread Search is " + se.getTimeOfSingleThreadingSearch());

        System.out.println("Printing the Future List: ");
        for (Future<Integer> future: se.getFutureList()) {
            System.out.println(future.get());
        }
    }
}
