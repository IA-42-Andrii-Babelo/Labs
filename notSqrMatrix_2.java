package org.example;

public class notSqrMatrix_2 {
    public static void main(String[] args) {
    int[][] a = {
            {1,2},
            {4,5},
            {6,7},
    };
        System.out.println(matrix_getTransposed(a));
    Result(matrix_getTransposed(a));
    }

   static int[][] matrix_getTransposed(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                result[j][i] = matrix[i][j];
            }
        }


   return result; }

    public static void Result(int[][] matrix){
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}
