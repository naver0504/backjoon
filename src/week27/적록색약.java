package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {

    static String[] lines;
    static int N;
    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};
    static int first = 0;
    static int second = 0;

    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new String[N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            lines[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                bfs(i, j, lines[i].charAt(j));
                first++;

            }
        }

        for (int i = 0; i < N; i++) {
            lines[i] = lines[i].replace('R', 'G');
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                bfs(i, j, lines[i].charAt(j));
                second++;

            }
        }
        System.out.println(first + " " + second);

    }

    public static void bfs(int x, int y, char c) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ndx = poll[0] + idx[i];
                int ndy = poll[1] + idy[i];
                if(isOutOfRange(ndx, ndy)) continue;
                if(visited[ndx][ndy]) continue;
                if(lines[ndx].charAt(ndy) != c) continue;

                visited[ndx][ndy] = true;
                queue.offer(new int[]{ndx, ndy});
            }
        }
    }

    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= N || ndy >= N);
    }
}
