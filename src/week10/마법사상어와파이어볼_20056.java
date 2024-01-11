package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마법사상어와파이어볼_20056 {

    static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int dir;

        public FireBall(int r, int c, int m, int s, int dir) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.dir = dir;
        }
    }

    static int N, M, K;

    static int[][] map;
    static int[] idx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] idy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        List<FireBall> fireBalls = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            map[r][c] += 1;
            fireBalls.add(new FireBall(r, c, m, s, dir));
        }

        for (int i = 0; i < K; i++) {
            moveFireBall(fireBalls);
            fireBalls = splitFireBall(fireBalls);
        }

        int result = 0;
        for (FireBall fireBall : fireBalls) {
            result += fireBall.m;
        }

        System.out.println(result);


    }

    private static List<FireBall> splitFireBall(List<FireBall> fireBalls) {
        List<FireBall> newFireBalls = new ArrayList<>();
        int size = fireBalls.size();
        for (int k = 0; k < size; k++) {
            FireBall fireBall = fireBalls.get(k);
            if (map[fireBall.r][fireBall.c] == 1) {
                newFireBalls.add(fireBalls.get(k));
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2) {
                    int sumM = 0;
                    int sumS = 0;
                    int cnt = 0;
                    int even = 0;
                    for (int k = 0; k < size; k++) {
                        FireBall fireBall = fireBalls.get(k);
                        if (fireBall.r == i && fireBall.c == j) {
                            sumM += fireBall.m;
                            sumS += fireBall.s;
                            cnt++;
                            if(fireBall.dir % 2 == 0) even++;
                        }
                    }
                    map[i][j] = 0;
                    int newM = sumM / 5;
                    int newS = sumS / cnt;
                    if (newM != 0) {
                        map[i][j] = 4;
                        if (even == 0 || even == cnt) {
                            for (int k = 0; k < 8; k += 2) {
                                newFireBalls.add(new FireBall(i, j, newM, newS, k));
                            }
                        } else {
                            for (int k = 1; k < 8; k += 2) {
                                newFireBalls.add(new FireBall(i, j, newM, newS, k));
                            }
                        }
                    }
                }
            }
        }

        return newFireBalls;
    }

    private static void moveFireBall(List<FireBall> fireBalls) {
        for (FireBall fireBall : fireBalls) {
            int nr = (N+fireBall.r + (idx[fireBall.dir] * fireBall.s % N))%N;
            int nc = (N+fireBall.c + (idy[fireBall.dir] * fireBall.s % N))%N;
            map[fireBall.r][fireBall.c] -= 1;

            fireBall.r = nr;
            fireBall.c = nc;

            map[fireBall.r][fireBall.c] += 1;
        }
    }

}
