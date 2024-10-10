package org.example;

import java.util.Arrays;

public class lab4_3 {
    public static void main(String[] args) {
    double[] arr = {10, 5, 15, 2, 8};
    double[] newArr = transformArray(arr);

    System.out.println(Arrays.toString(newArr));
}

    public static double[] transformArray(double[] arr) {
        double minElem = Arrays.stream(arr).min().getAsDouble();

        if (minElem == 0) {
            Arrays.fill(arr, -10);
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] / minElem;
            }
        }

        return arr;
    }

}

