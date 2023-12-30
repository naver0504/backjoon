package week8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465 {

    static int T;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = 1;
            while (st.hasMoreTokens()) {
                stickers[0][col++] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            col = 1;

            while (st.hasMoreTokens()) {
                stickers[1][col++] = Integer.parseInt(st.nextToken());
            }
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }

            if (dp[0][n] > dp[1][n]) {
                sb.append(dp[0][n]);
            } else {
                sb.append(dp[1][n]);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

}
