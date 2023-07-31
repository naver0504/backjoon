package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기1 {
    static int[][] arr;

    static int[] idx = {0, 1, 0, -1};
    static int[] idy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int layer = Math.min(n, m) / 2;

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        r %= 2*(n + m) - 4;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < layer; j++) {
                int count = 0;
                int x = j;
                int y = j;
                int tmp = arr[x][y];
                while (count < 4) {
                    int nx = x + idx[count];
                    int ny = y + idy[count];
//                    static int[] idx = {0, 1, 0, -1};
//                    static int[] idy = {1, 0, -1, 0};

                    if (nx >= j && ny >= j && nx < n - j && ny < m - j) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        count++;
                    }

                }
                arr[j+1][j] = tmp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
