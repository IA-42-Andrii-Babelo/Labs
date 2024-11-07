package org.example;

public class Strategy_24_10_lab7 {

    public static void main(String[] args) {
        byte[] arr1 = {5, 6, 2, 6, 1, -53, 12};
        byte[] arr2 = {15, -3, 24, 0, -10, 89, 13, 1};
        byte[] arr3 = {7, 3, 9, 1, -5, 4};


        Sorter sorter = new Sorter(new Bubble_Sort());
        sorter.sort(arr1);
        printArray(arr1);
        System.out.println();

        sorter.setStrategy(new Selection_Sort());
        sorter.sort(arr2);
        printArray(arr2);
        System.out.println();

        sorter.setStrategy(new Insertion_Sort());
        sorter.sort(arr3);
        printArray(arr3);
        System.out.println();
    }

    public interface Sort_Strategy {
        void sort(byte[] arr);
    }

    public static class Bubble_Sort implements Sort_Strategy {
        @Override
        public void sort(byte[] arr) {
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


    public static class Selection_Sort implements Sort_Strategy {
        @Override
        public void sort(byte[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int index = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[index]) {
                        index = j;
                    }
                }
                byte temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }


    public static class Insertion_Sort implements Sort_Strategy {
        @Override
        public void sort(byte[] arr) {
            for (int i = 1; i < arr.length; i++) {
                byte key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j] < key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }
    }

    public static class Sorter {
        private Sort_Strategy strategy;

        public Sorter(Sort_Strategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(Sort_Strategy strategy) {
            this.strategy = strategy;
        }

        public void sort(byte[] arr) {
            strategy.sort(arr);
        }
    }

    private static void printArray(byte[] arr) {
        for (byte byt : arr) {
            System.out.print(byt + " ");
        }
    }
}
