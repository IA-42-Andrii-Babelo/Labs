package org.example;

public class Sum {
    public static void main(String[] args) {
        printResults(10);
        printResults(901234);
        printResults(-901234);
        printResults(17);
        printResults(8564);
        printResults(23574656);
    }

    public static double sum(int m) {
        double sum = 0;
        int k = 30;
        for (double i = 1; i <= k; i++) {
            sum += Math.sqrt(m * (1 / i)) * Math.sin(m * i);
        }
        return sum;
    }

    static void printResults(int m) {
        try {
            System.out.println("result: " + sum(m));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}


