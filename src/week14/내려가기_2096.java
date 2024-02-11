package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096 {

    static int N;
    static int[][] lines;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new int[N][3];
        dp = new int[N][3][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                lines[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j][0] = lines[i][j];
                dp[i][j][1] = lines[i][j];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]) + lines[i][0];
                    dp[i][j][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1]) + lines[i][0];

                } else if (j == 1) {
                    dp[i][j][0] = Math.max(dp[i - 1][0][0], Math.max(dp[i - 1][1][0], dp[i - 1][2][0])) + lines[i][1];
                    dp[i][j][1] = Math.min(dp[i - 1][0][1], Math.min(dp[i - 1][1][1], dp[i - 1][2][1])) + lines[i][1];

                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][1][0], dp[i - 1][2][0]) + lines[i][2];
                    dp[i][j][1] = Math.min(dp[i - 1][1][1], dp[i - 1][2][1]) + lines[i][2];

                }
            }
        }

        int max = Math.max(dp[N - 1][0][0], Math.max(dp[N - 1][1][0], dp[N - 1][2][0]));
        int min = Math.min(dp[N - 1][0][1], Math.min(dp[N - 1][1][1], dp[N - 1][2][1]));


        System.out.println(max + " " + min);

    }
}
