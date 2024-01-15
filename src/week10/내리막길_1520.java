package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 내리막길_1520 {

    static int[][] map;
    static int[][] dp;

    static int M;
    static int N;

    static int[] idx = {-1, 0, 1, 0};
    static int[] idy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }




        System.out.println(  dfs(0, 0));


    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        } else {

            if (dp[x][y] == -1) {
                dp[x][y] = 0;

                for (int i = 0; i < 4; i++) {
                    int ndx = x + idx[i];
                    int ndy = y + idy[i];
                    if (ndx < 0 || ndy < 0 || ndx >= M || ndy >= N) continue;
                    if (map[x][y] > map[ndx][ndy]) {
                        dp[x][y] += dfs(ndx, ndy);
                    }
                }
            }
            return dp[x][y];
        }
    }
}
