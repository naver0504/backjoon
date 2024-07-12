package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳_1987 {

    static int R;
    static int C;

    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};
    static int answer = 0;

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) - 'A';
            }
        }

        boolean[] visited = new boolean['Z' - 'A' + 1];
        visited[map[0][0]] = true;
        dfs(1, 0, 0, visited);
        System.out.println(answer);
    }

    private static void dfs(int depth, int x, int y, boolean[] visited) {

        answer = Math.max(answer, depth);
        for (int i = 0; i < 4; i++) {
            int ndx = x + idx[i];
            int ndy = y + idy[i];
            if(isOutOfRange(ndx, ndy)) continue;
            if(visited[map[ndx][ndy]]) continue;
            visited[map[ndx][ndy]] = true;
            dfs(depth + 1, ndx, ndy, visited);
            visited[map[ndx][ndy]] = false;

        }
    }

    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= R || ndy >= C);
    }
}
