package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전2_2294 {
    static int N;
    static int K;
    static int[] dp;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        values = new int[N + 1];
        dp = new int [K + 1];

        for (int i = 1; i <= N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp, 10_001);
        Arrays.sort(values);




        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= values[i]) {
                    dp[j] = Math.min(dp[j - values[i]] + 1, dp[j]);
                }
            }
        }

        System.out.println(dp[K] == 10_001 ? -1 : dp[K]);
    }
}
