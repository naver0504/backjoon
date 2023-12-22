package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드_11404 {

    static int N , M;
    static long[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        result = new long[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
               result[i][j] = Integer.MAX_VALUE;
               if(i==j)
                     result[i][j] = 0;
            }
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            result[a][b] = Math.min(result[a][b], cost);
        }

        for (int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i == j)
                        continue;

                    result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j] >= Integer.MAX_VALUE ? 0 : result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);



    }
}
