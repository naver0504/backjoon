package week29;

import java.util.Scanner;

public class 타일채우기_2133 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 2; i <= n; i += 2) {
            dp[i] += dp[i - 2] * 3;
            for (int j = 0; j <=i - 4; j += 2) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[n]);
    }

}
