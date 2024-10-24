package org.example;

public class Buble_sort_for {
    public static void main(String[] args) {
        byte[] arr = {5, 6, 2, 6,1, 23, 12};
        bubbleS(arr);

        for (byte byt : arr){
            System.out.println(byt );
        }
    }

    public static void bubbleS(byte[] arr){
        boolean swapped = true;
        int i = 0;

        while (swapped) {
           swapped = false;
            for (int j = 0; j < arr.length - i - 1 ; j++) {
                if (arr[j] < arr[j+1]){
                    byte temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                    swapped = true;

                }
            }
            i++;
        }
    }

}
