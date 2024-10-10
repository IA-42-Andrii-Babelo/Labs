package org.example;

public class lab4_1 {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 3, 10, 7, 6};

        double result = calculateGeometricMeanOfEven(array);

        if (result > 0) {
            System.out.println(result);
        } else {
            System.out.println("У масиві немає парних елементів або є нуль в масиві");
        }
    }

    public static double calculateGeometricMeanOfEven(int[] array) {
        double product = 1.0;
        int count = 0;

        for (int num : array) {
            if (num % 2 == 0) {
                product *= num;
                count++;
            }
        }

        if (count > 0) {
            return Math.pow(product, 1.0 / count);
        } else {
            return -1;
        }
    }
}
