package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자_1976 {


    static int N;
    static int M;

    static int[][] map;
    static int[] plans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        plans = new int[M];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(i == j){
                    map[i][j] = 1;
                    continue;
                }

                map[i][j] = value;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        int startIdx = plans[0];
        for (int i = 1; i < M; i++) {
            if(map[startIdx][plans[i]] == 0) {
                System.out.println("NO");
                return;
            }

            startIdx = plans[i];
        }

        System.out.println("YES");
    }
}
