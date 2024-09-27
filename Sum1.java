package org.example;

public class Sum1 {

public static void main(String[] args) {
    printResults(2,3);
    printResults(1, 0);
    printResults(1, 1);
    printResults(2, 1);
    printResults(1, 2);
    printResults(2, -10);
    printResults(20, 20);
    printResults(21, 21);
    printResults(1, 10);
    printResults(-1, 10);
    printResults(1, Integer.MAX_VALUE);

}

    static double sum(int t, int l) {
    double sum = 0;
    if (l%2==1){
        for (int i = 0; i < t; i++) {
            sum += Math.sqrt(t*l);
        }
        }
    else {
        for (int i = 0; i < t; i++) {
            sum += l/(Math.sqrt(t));
        }

    }
   return sum;
}

    static void printResults(int t, int l) {
        try {
            System.out.println("result: " + sum(t,l));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
