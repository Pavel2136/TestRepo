package task4;

public class MatrixDemo {

    public static void main(String[] args) {
        Matrix matrixTest = new Matrix(4,3);

        matrixTest.fillIn();
        matrixTest.print();
        System.out.println("****");

        System.out.println(matrixTest.getMaxInRow());

    }
}
