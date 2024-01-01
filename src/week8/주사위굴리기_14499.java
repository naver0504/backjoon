package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기_14499 {

    static int N;
    static int M;
    static int X;
    static int Y;
    static int K;
    static int[][] dice = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    static int[] idx = {0, 0, -1, 1};
    static int[] idy = {1, -1, 0, 0};
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            move(dir);
        }

        System.out.println(sb);


    }

    private static void rotate(int dir) {

        switch (dir) {
            case 1 -> {
                int up = dice[1][1];
                int right = dice[1][2];
                int down = dice[3][1];
                int left = dice[1][0];

                dice[1][1] = left;
                dice[3][1] = right;
                dice[1][0] = down;
                dice[1][2] = up;

            }
            case 2 -> {

                int up = dice[1][1];
                int right = dice[1][2];
                int down = dice[3][1];
                int left = dice[1][0];


                dice[1][1] = right;
                dice[3][1] = left;
                dice[1][0] = up;
                dice[1][2] = down;


            }
            case 3 -> {
                int tmp = dice[0][1];
                for (int i = 0; i < 3; i++) {
                    dice[i][1] = dice[i + 1][1];
                }
                dice[3][1] = tmp;
            }
            case 4 -> {
                int tmp = dice[3][1];
                for (int i = 3; i > 0; i--) {
                    dice[i][1] = dice[i - 1][1];
                }
                dice[0][1] = tmp;
            }
        }
    }

    private static void move(int dir) {

        if (X + idx[dir - 1] < 0 || X + idx[dir - 1] >= N || Y + idy[dir - 1] < 0 || Y + idy[dir - 1] >= M) {
            return;
        }

        rotate(dir);

        X += idx[dir - 1];
        Y += idy[dir - 1];
        if (map[X][Y] == 0) {
            map[X][Y] = dice[3][1];
        } else {
            dice[3][1] = map[X][Y];
            map[X][Y] = 0;
        }

        sb.append(dice[1][1]).append("\n");

    }
}
