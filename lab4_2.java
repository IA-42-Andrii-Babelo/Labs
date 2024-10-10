package org.example;

public class lab4_2 {
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 8, 6, 3, 7, 9, 2, 10};

        int result = calculateSumOfElements(array);

        System.out.println(result);



    }

    public static int calculateSumOfElements(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0 && array[i] > 3) {
                sum += array[i];
            }
        }

        return sum;
    }
}
