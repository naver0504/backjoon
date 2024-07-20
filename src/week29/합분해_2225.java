package week29;

import java.util.Scanner;

public class 합분해_2225 {

    static int N;
    static int K;

    static int[][] dp;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000;
            }
        }

        System.out.println(dp[N][K]);
    }
}
