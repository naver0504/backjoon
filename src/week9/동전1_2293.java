package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1_2293 {

    static int N;
    static int K;
    static int[] dp;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];
        coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - coin[i] >= 0 && dp[j - coin[i]] >= 1) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }
        System.out.println(dp[K]);
    }
}
