package week10;

import java.util.*;
import java.io.*;

public class 농장관리_1245 {

    static class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int N;
    static int M;
    static int result = 0;

    static int[] idx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] idy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static int[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    getResult(i, j, map[i][j], 0);
                }

            }
        }

        System.out.println(result);





    }

    private static void getResult(int x, int y, int value, int isTop) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            visited[poll.x][poll.y] = 1;

            for (int i = 0; i < 8; i++) {
                int ndx = poll.x + idx[i];
                int ndy = poll.y + idy[i];
                if(ndx <0 || ndy<0 || ndx>=N||ndy>=M) continue;
                if (map[ndx][ndy] == value) {
                    if(visited[ndx][ndy] == 1) continue;
                    queue.offer(new Pair(ndx, ndy));
                } else if (map[ndx][ndy] > value) {
                    isTop = 1;
                }
            }
        }

        if(isTop == 0) result++;

    }
}
