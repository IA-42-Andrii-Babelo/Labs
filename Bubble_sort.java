package org.example;

public class Bubble_sort {
    public static void main(String[] args) {
        byte[] arr = {5, 6, 2, 6,1, 23, 12};
        bubbleSort(arr);

        for (byte byt : arr) {
            System.out.print(byt);
            System.out.println();
        }
    }

    public static void bubbleSort(byte[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    byte temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }







}

