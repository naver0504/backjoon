package week11;

import java.util.Scanner;

public class 오르막수_11057 {

    static int[][] dp;


    /***
     *
     *
     *
     * 1 -> 0 ~ 9 = 10
     * 2 -> 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 = 55
     * 3 -> 55 + 45 + 36 + 28 + 21 + 15 + 10 + 6 + 3 + 1
     * 4 -> 220 + 165 + 129 +
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        int result = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] = (dp[i][j]%10007 + dp[i-1][k]%10007)%10007;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            result = (result%10007 + dp[N][i]%10007)%10007;
        }

        System.out.println(result);


    }
}
