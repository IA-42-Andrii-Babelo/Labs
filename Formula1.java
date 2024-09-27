package org.example;

public class Formula1 {
    public static void main(String[] args) {
        double a = 1.478;
        double b = 9.26;
        double c = 0.68;
        double d = 2.24;

        double y = calculateY(a, b, c, d);
        System.out.println("Значення У: " + y);
    }

    public static double calculateY(double a, double b, double c, double d) {
        if (a == 0) {
            throw new IllegalArgumentException("a не може бути нулем ");
        }

        double logPart = Math.log(Math.abs(b) / Math.abs(a));

        double shPart = Math.sinh(c);

        double expPart = Math.exp(d);

        double y = 2 * (logPart + Math.sqrt(shPart + expPart));
        return y;
    }
}