package org.example;

public class matrix_1 {
    public static void main(String[] args) {
int[][] a = {
        {1,2,3},
        {4,5,6},
        {7,8,9}};
        transpose(a);
        
    }


  public static void transpose(int[][] matrix) {
        int n = matrix.length;

      for (int i = 0; i < n ; i++) {
          for (int j = i+1; j < n ; j++) {
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
      }

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              System.out.print(matrix[i][j]+" ");
          }
          System.out.println();
      }


    }
    
}
