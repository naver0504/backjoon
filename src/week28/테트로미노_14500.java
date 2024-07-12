package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {

    static int[] idx = {0, 1, 0};
    static int[] idy = {-1, 0, 1};
    static int[][] map;
    static int N;
    static int M;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(0, map[i][j], i, j, visited);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }


    public static void dfs(int depth, int sum,
                           int x, int y, boolean[][] visited) {

        if (depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int ndx = x + idx[i];
            int ndy = y + idy[i];
            if(isOutOfRange(ndx, ndy)) continue;
            if(visited[ndx][ndy]) continue;
            if (depth == 1) {
                visited[ndx][ndy] = true;
                dfs(depth + 1, sum + map[ndx][ndy], x, y, visited);
                visited[ndx][ndy] = false;

            }
            visited[ndx][ndy] = true;
            dfs(depth + 1, sum + map[ndx][ndy], ndx, ndy, visited);
            visited[ndx][ndy] = false;
        }
    }

    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= N || ndy >= M);
    }
}
