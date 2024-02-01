package week12;

import java.util.*;

public class 로마숫자_2608 {

    static Map<String, Integer> single = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );

    static Map<String, Integer> two = Map.of(
            "IV", 4,
            "IX", 9,
            "XL", 40,
            "XC", 90,
            "CD", 400,
            "CM", 900
            );

    static Set<String> vld = Set.of(
            "V",
            "L",
            "D"
    );

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        int number1 = getNumber(first);
        int number2 = getNumber(second);
        int result = number1 + number2;
        System.out.println(result);
        System.out.println(getString(result));

    }

    private static String getString(int result) {
        StringBuilder sb = new StringBuilder();

        if (result / 1000 > 0) {
            int times = result / 1000;
            for (int i = 0; i < times; i++) {
                sb.append("M");
            }
            result -= times * 1000;

        }

        if (result / 900 > 0) {
            sb.append("CM");
            result %= 900;
        }

        if (result / 500 > 0) {
            sb.append("D");
            result %= 500;
        }

        if (result / 400 > 0) {
            sb.append("CD");
            result %= 400;
        }

        if (result / 100 > 0) {
            int times = result / 100;
            for (int i = 0; i < times; i++) {
                sb.append("C");
            }
            result -= 100*times;
        }

        if (result / 90 > 0) {
            sb.append("XC");
            result %= 90;
        }

        if (result / 50 > 0) {
            sb.append("L");
            result %= 50;
        }

        if (result / 40 > 0 ) {
            sb.append("XL");
            result %= 40;
        }

        if (result / 10 > 0) {
            int times = result / 10;
            for (int i = 0; i < times; i++) {
                sb.append("X");
            }
            result -= 10*times;
        }

        if (result / 9 > 0) {
            sb.append("IX");
            result %= 9;
        }
        if (result / 5 > 0) {
            sb.append("V");
            result %= 5;
        }

        if (result / 4 > 0) {
            sb.append("IV");
            result %= 4;
        }

        for (int i = 0; i < result; i++) {
            sb.append("I");
        }


        return sb.toString();




    }

    private static int getNumber(String first) {

        int result = 0;
        for (int i = 0; i < first.length(); i++) {
            String s1 = String.valueOf(first.charAt(i));
            if (s1.equals("I") || s1.equals("X") || s1.equals("C")) {
                if (i != first.length() - 1) {
                    String s2 = String.valueOf(first.charAt(i + 1));
                    if (two.containsKey(s1 + s2)) {
                        i++;
                        result += two.get(s1 + s2);
                    } else {
                        result += single.get(s1);
                    }
                } else {
                    result += single.get(s1);
                }
            } else {
                result += single.get(s1);
            }
        }
        return result;
    }
}
