package org.example;
public class Sel_sort {
    public static void main(String[] args) {
        byte[] arr = {15, -3, 24, 0, -10, 89, 13, 1};
        sel_sort(arr);
        for (byte byt : arr){
            System.out.println(byt);

        }
    }

    public static void sel_sort(byte[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
        int index = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[j] > arr[index]) {
                    index = j;
                }
            }
                byte temp = arr[index];
                arr[index] = arr[i];
                arr[i]  = temp;
            }
        }
    }


