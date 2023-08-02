package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로보성소기14503 {

    static int[] idx = {-1, 0, 1, 0};
    static int[] idy = {0, -1, 0, 1};

    static int[][] visited;
    static int[][] map;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N][M];
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int d =  Integer.parseInt(st.nextToken());
        if (d == 1) {
            d = 3;
        } else if (d == 3) {
            d = 1;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int stop = 0;
        while (stop < 1) {
            if (visited[startX][startY] == 0) {
                visited[startX][startY] = 1;
                result++;
            }
            int count = 0;
            boolean isThereCanMove = false;
            while (count < 4) {
                int nx = startX + idx[count];
                int ny = startY + idy[count];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (visited[nx][ny] == 0 && map[nx][ny] == 0) {
                        isThereCanMove = true;
                        break;
                    }
                }
                count++;
            }

            if (isThereCanMove) {
                d = (d + 1) % 4;
                int nx = startX + idx[d];
                int ny = startY + idy[d];
                if (visited[nx][ny] == 0 && map[nx][ny] == 0) {
                    startX = nx;
                    startY = ny;
                }
            } else {
                int tmpD = (d + 2) % 4;
                int nx = startX + idx[tmpD];
                int ny = startY + idy[tmpD];
                if (map[nx][ny] == 1) {
                    stop = 1;
                } else {
                    startX = nx;
                    startY = ny;
                }
            }

        }

        System.out.println(result);
    }

}
