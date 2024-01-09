package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와토네이도_20057 {

    static int[][] sand;
    static int N;
    static int result = 0;
    static int[] idx = {0, 1, 0, -1};
    static int[] idy = {-1, 0, 1, 0};
    static int R, C;


    static int[][] spreadR = {
            {-1,1,-2,2,-1,1,-1,1,0,0}, // 좌
            {-1,-1,0,0,0,0,1,1,2,1}, // 하
            {-1,1,-2,2,-1,1,-1,1,0,0}, // 우
            {1,1,0,0,0,0,-1,-1,-2,-1}, // 상
    };
    static int[][] spreadC = {
            {1,1,0,0,0,0,-1,-1,-2,-1}, // 좌
            {-1,1,-2,2,-1,1,-1,1,0,0}, // 하
            {-1,-1,0,0,0,0,1,1,2,1}, // 우
            {-1,1,-2,2,-1,1,-1,1,0,0}, // 상
    };

    static int[] percent = {1, 1, 2, 2, 7, 7, 10, 10, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sand = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sand[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        R = N/2;
        C = N/2;
        int length = 1;
        int count = 0;
        int dir = 0;
        while (true) {

            for (int i = 0; i < length; i++) {
                moveTornado(dir);
                flySand(dir);
                if (R == 0 && C == 0) {
                    System.out.println(result);
                    return;
                }
            }
            dir = setDirection(dir);
            count++;

            if (count == 2) {
                length++;
                count = 0;
            }


        }


    }

    private static void flySand(int dir) {

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int nextR = R + spreadR[dir][i];
            int nextC = C + spreadC[dir][i];

            int amount = (sand[R][C] * percent[i]) / 100;
            sum += amount;
            if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
                result += amount;
            } else {
                sand[nextR][nextC] += amount;
            }
        }

        int nextR = R + spreadR[dir][9];
        int nextC = C + spreadC[dir][9];

        if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N) {
            result += (sand[R][C] - sum);
        } else {
            sand[nextR][nextC] += (sand[R][C] - sum);
        }

        sand[R][C] = 0;

    }

    private static void moveTornado(int dir) {
        R = R + idx[dir];
        C = C + idy[dir];
    }

    private static int setDirection(int dir) {
        // 서 -> 남 -> 동 -> 북
        return (dir + 1) % 4;
    }

}

