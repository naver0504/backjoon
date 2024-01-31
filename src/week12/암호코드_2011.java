package week12;

import java.util.Scanner;

public class 암호코드_2011 {



    static String input;
    static int[] dp;
    static int END = 26;
    static String ZERO = "0";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        dp = new int[input.length() + 1];
        dp[0] = 1;
        boolean flag = false;

        if(input.charAt(0) == '0') flag = true;
        else dp[1] = 1;

        for (int i = 1; i < input.length(); i++) {
            String s0 = String.valueOf(input.charAt(i-1));
            String s1 = String.valueOf(input.charAt(i));
            int s0s1 = Integer.parseInt(s0 + s1);
            if (s1.equals(ZERO)) {
                if (s0s1 > 26 || s0s1 < 10) {
                    flag = true;
                    break;
                }
            } else{
                dp[i + 1] = (dp[i + 1] % 1000000 + dp[i] % 1000000) % 1000000;
            }

            if (s0s1 <= END && s0s1>= 10) {
                dp[i + 1] = (dp[i + 1] % 1000000 + (dp[i - 1]) % 1000000) % 1000000;
            }

        }

        System.out.println(flag ? ZERO : dp[input.length()]);
    }
}
