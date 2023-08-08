package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 배열돌리기4_17406 {
    static int[] visited;
    static int N;
    static int M;
    static int K;
    static int result = Integer.MAX_VALUE;


    static class RCS {
        int r;
        int c;
        int s;
        
        public RCS(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    
    }
    

    static int[] idx = {1, 0, -1, 0};
    static int[] idy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] map;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<RCS> list = new ArrayList<>(K);
        visited = new int[K];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new RCS(r, c, s));
        }

        backTracking(0, map, list);




        System.out.println(result);


    }

    public static void backTracking(int depth, int[][] arr, List<RCS> list) {
        if (depth == K) {
            setResult(arr);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                int[][] clone = new int[N][M];
                for (int j = 0; j < N; j++) {
                    System.arraycopy(arr[j], 0, clone[j], 0, M);
                }
                spinArray(list.get(i).r, list.get(i).c, list.get(i).s, clone);
                backTracking(depth + 1, clone, list);
                visited[i] = 0;
            }
        }
    }


    private static void setResult(int[][] map) {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
            result = Math.min(result, sum);
        }
    }

    private static int[][] spinArray(int r, int c, int s, int[][] arr) {
        int x1 = r - s - 1;
        int y1 = c - s - 1;
        int x2 = r + s - 1;
        int y2 = c + s - 1;

        int layer = 0;

        while (layer < s) {
            int startX = x1 + layer;
            int startY = y1 + layer;
            int startValue = arr[startX][startY];

            int endX = x2 - layer;
            int endY = y2 - layer;

            int count = 0;

            int x = startX;
            int y = startY;

            while (count < 4) {
                int nx = x + idx[count];
                int ny = y + idy[count];

                if (nx >= startX && ny >= startY && nx <= endX && ny <= endY) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    count++;
                }
            }
            arr[startX][startY + 1] = startValue;
            layer++;

        }
        
        return arr;
    }
}
