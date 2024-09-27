package org.example;


public class Main {
    public static void main(String[] args) {

        double a = 0.345;
        double b = -2.25;
        double c = 2.65;
        double d = 3.99;

        double part1 = (5 * a) / Math.sin(a);

        double absB = Math.abs(b);
        double thPart = Math.tanh(absB * c);
        double lnPart = Math.log(d);
        double part2 = Math.sqrt(thPart / lnPart);

        double y = part1 + part2;

        System.out.println("Значення У: " + y);
    }
}

