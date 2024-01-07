package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

    static class Pair{
        int x;
        int y;
        int day;

        public Pair(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }


    static int[][] tomatoes;
    static Queue<Pair> queue = new LinkedList<>();
    static int idx[] = {-1, 1, 0, 0};
    static int idy[] = {0, 0, -1, 1};

    static int N, M;
    static int plusOne = 0;
    static int minusOne = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int ripe = Integer.parseInt(st.nextToken());
                tomatoes[i][j] = ripe;
                if (ripe == 1) {
                    queue.add(new Pair(i, j, 0));
                    plusOne++;
                } else if (ripe == -1) {
                    minusOne++;
                }
            }
        }

        if (queue.size() == N * M) {
            System.out.println(0);
        } else {
            bfs();
            if (minusOne + plusOne == N * M) {
                System.out.println(result);
            } else {
                System.out.println(-1);
            }
        }

    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            result = poll.day;

            for (int i = 0; i < 4; i++) {
                int nx = x + idx[i];
                int ny = y + idy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (tomatoes[nx][ny] == 0) {
                    tomatoes[nx][ny] = 1;
                    plusOne++;
                    queue.add(new Pair(nx, ny, poll.day+1));
                }
            }

        }

    }
}
