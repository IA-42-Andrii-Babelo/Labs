package org.example;

public class hexStringInt {
    public static void main(String[] args) {

        System.out.println(hexStringToInt("CAFE"));
        System.out.println(hexStringToInt("1234"));
        System.out.println(hexStringToInt("Becca"));
        try {
            System.out.println(hexStringToInt("G123"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        String string = "      sd sa s s a       ";

        String str2 =   string.replaceAll("\\s", "");
        System.out.println(str2);

        String str3 = string.trim();
        System.out.println(str3);


    }


    public static int hexStringToInt(String s) {
        if (s == null || s.isEmpty() || !s.matches("[0-9A-Fa-f]+")) {
            throw new IllegalArgumentException("Неправильна стрінга");
        }
        return Integer.parseInt(s, 16);
    }

}
