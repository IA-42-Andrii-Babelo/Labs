package org.example;


public class Sum2 {
    public static void main(String[] args) {
    printResults(1e-6);
        printResults(1e-5);
        printResults(0.0000000008);
        printResults(0);
        printResults(0.5);
        printResults(0.00000000000000003);
    }
    static double sum(double epsilon) {
        if (epsilon <= 0){
            System.out.print("Ваше число нуль або менше тому " );
            return 0;
        }
        double sum = 0;
        int i = 1;
        while (true){
            double term = 1.0/(i*(i+1.0));
            if (Math.abs(term)< epsilon){
                break;
            }
            sum += term;
            i++;

        }


        return sum;
    }



    static void printResults(double eps) {
        try {
            System.out.println("результат: " + sum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка! " + e.getMessage());
        }
    }
}
