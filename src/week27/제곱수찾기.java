package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제곱수찾기 {
    static int N;
    static int M;
    static int[][] map;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dx = -N + 1; dx <= N; dx++) {
                    for (int dy = -M + 1; dy <= M; dy++) {
                        if (dx == 0 && dy == 0) continue;
                        dfs(i, j, map[i][j], dx, dy);
                    }
                }

            }
        }

        System.out.println(answer == Integer.MIN_VALUE? -1 : answer);

    }


    public static void dfs(int x, int y, int value, int dx, int dy) {
        double sqrt = Math.sqrt(value);
        if((int) sqrt == sqrt ) answer = Math.max(answer, value);
        int ndx = x + dx ;
        int ndy = y + dy;
        if (isOutOfRange(ndx, ndy)) return;
        int nextValue = 10 * value + map[ndx][ndy];
        dfs(ndx, ndy, nextValue, dx, dy);
    }

    static public boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 ||  ndy < 0 || ndx >= N || ndy >= M);
    }
}
