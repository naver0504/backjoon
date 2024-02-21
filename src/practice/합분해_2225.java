package practice;

import java.util.Scanner;

public class 합분해_2225 {


    static int DIVIDE = 1_000_000_000;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;

        }

        for (int i = 1; i <= k; i++) {
            dp[0][i] = 1;

        }


        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i][j] + dp[i][j - 1]) % DIVIDE;
                dp[i][j] = (dp[i][j] + dp[i - 1][j] % DIVIDE) % DIVIDE;
            }
        }

        System.out.println(dp[n][k]);

    }
}
