package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프_1890 {

    static int N;
    static int[][] map;
    static long [][] dp;

    static int[] idx = {0, 1};
    static int[] idy = {1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[N][N];
        dp = new long [N][N];

        for(int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        getResult(0, 0);

        System.out.println(dp[0][0]);
    }

    private static long getResult(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            return 1;
        } else {

            if(dp[x][y] != 0) {
                return dp[x][y];
            }

            int jump = map[x][y];

            if(jump == 0) {
                return 0;
            }

            for(int i = 0; i< 2; i++) {
                int ndx = x + idx[i] * jump;
                int ndy = y + idy[i] * jump;

                if (ndx < 0 || ndy < 0 || ndx >= N || ndy >= N) continue;
                dp[x][y] += getResult(ndx, ndy);
            }

            return dp[x][y];
        }
    }
}
