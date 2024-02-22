package practice;

import java.util.Scanner;

public class 자두나무_2240 {

    static int[] arr;
    static int T;
    static int W;
    static int[][][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        W = sc.nextInt();

        arr = new int[T + 1];
        dp = new int[T + 1][W + 1][2];

        for (int i = 1; i <= T; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr[1] == 1) {
            dp[1][0][0] = 1;
            dp[1][1][1] = 0;
        } else {
            dp[1][0][0] = 0;
            dp[1][1][1] = 1;
        }

        for (int i = 2; i <= T; i++) {

            dp[i][0][0] = dp[i - 1][0][0] + 2 - arr[i];

            for (int j = 1; j <= W; j++) {
                    if (arr[i] == 1) {
                        dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]) + 1;
                        dp[i][j][1] = Math.max(dp[i-1][j-1][0], dp[i-1][j][1]);
                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1]);
                        dp[i][j][1] = Math.max(dp[i-1][j - 1][0], dp[i-1][j][1]) + 1;
                    }
                }
            }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= W; i++) {
            max = Math.max(max, Math.max(dp[T][i][0], dp[T][i][1]));
        }

        System.out.println(max);


    }

}
