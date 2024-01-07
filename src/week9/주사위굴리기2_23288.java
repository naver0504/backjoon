package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 주사위굴리기2_23288 {



    static int[] dice = {2, 4, 1, 3, 5, 6};
    static int[] idx = {0, 1, 0, -1};
    static int[] idy = {1, 0, -1, 0};
    static int[][] map;
    static int N;
    static int M;
    static int K;
    static int X = 0;
    static int Y = 0;
    static int dir = 0;
    static int result = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            rollDice();
        }
        System.out.println(result);
    }

    private static void rollDice() {

        int ndx = X + idx[dir];
        int ndy = Y + idy[dir];
        //동 -> 남 -> 서 -> 북
        if (ndx < 0 || ndy < 0 || ndx >= N || ndy >= M) {
                dir = (dir + 2) % 4;
                ndx = X + idx[dir];
                ndy = Y + idy[dir];
        }
        X = ndx;
        Y = ndy;
        setDice(dir);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(X, Y));
        int[][] visited = new int[N][M];
        visited[X][Y] = 1;

        int m = map[X][Y];
        int c = 1;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;
            for (int i = 0; i < 4; i++) {
                int nextX = x + idx[i];
                int nextY = y + idy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)  continue;
                if(visited[nextX][nextY] == 1) continue;
                if (map[nextX][nextY] == m) {
                    queue.add(new Pair(nextX, nextY));
                    c++;
                    visited[nextX][nextY] = 1;
                }
            }
        }

        result += m * c;

        if (dice[5] > map[X][Y]) {
            setDirection(1);
        } else if (dice[5] < map[X][Y]) {
            setDirection(-1);
        }


    }

    private static void setDice(int dir) {
        switch (dir) {
            case 0 -> {
                int left = dice[1];
                int up = dice[2];
                int right = dice[3];
                int bottom = dice[5];

                dice[1] = bottom;
                dice[2] = left;
                dice[3] = up;
                dice[5] = right;
            }
            case 1 -> {
                int front = dice[0];
                int up = dice[2];
                int back = dice[4];
                int bottom = dice[5];

                dice[0] = bottom;
                dice[2] = front;
                dice[4] = up;
                dice[5] = back;
            }
            case 2 -> {
                int left = dice[1];
                int up = dice[2];
                int right = dice[3];
                int bottom = dice[5];

                dice[1] = up;
                dice[2] = right;
                dice[3] = bottom;
                dice[5] = left;
            }

            case 3 -> {
                int front = dice[0];
                int up = dice[2];
                int back = dice[4];
                int bottom = dice[5];

                dice[0] = up;
                dice[2] = back;
                dice[4] = bottom;
                dice[5] = front;
            }
        }
    }

    static private void setDirection(int rotate) {
        if (rotate == 1) {
            dir = (dir + 1) % 4;
            return;
        }
        dir = (dir + 3) % 4;
    }
}
