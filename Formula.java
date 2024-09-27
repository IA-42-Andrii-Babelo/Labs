package org.example;

public class Formula {
    public static void main(String[] args) {
        double a = 2.34;
        double b = 0.756;
        double c = 2.23;
        double d = -1.653;//1.653

        double expC = Math.exp(c);
        double lgA = Math.log10(a);
        double part1 = expC + 2 * lgA;

        double sqrtPart = Math.sqrt(Math.pow(c, b));

        double absArcsinD = 0;
        if (d >= -1 && d <= 1) {
            absArcsinD = Math.abs(Math.asin(d));
        } else {
            System.out.println("Помилка, значення d має бути в межах [-1, 1] для функції арксинуса.");
            return;
        }

        double y = (part1 / sqrtPart) * absArcsinD;

        System.out.println("Результат: " + y);
    }
}
