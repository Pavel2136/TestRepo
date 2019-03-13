package task4;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] matrix;
    private int maxInRow = 0;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[rows][columns];
    }

    public void fillIn() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int)(Math.random() * 10001);
            }
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getNum(int rows, int column){
        return matrix[rows][column];
    }

    public int getMaxInRow() { // надо доработать
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxInRow < matrix[i][j]) {
                    maxInRow = matrix[i][j];
                }
            }
        }
        return maxInRow;
    }
}
