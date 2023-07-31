package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수강과목 {

    static int N, K;
    static int[] v;
    static int[] t;
    static int[][] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = getInteger(st.nextToken());
        K = getInteger(st.nextToken());
        array = new int[K+1][N+1];
        v = new int[K+1];
        t = new int[K+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = getInteger(st.nextToken());
            t[i] = getInteger(st.nextToken());
        }
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (t[i - 1] <= j) {
                    array[i][j] = Math.max(v[i - 1] + array[i - 1][j - t[i - 1]], array[i - 1][j]);
                } else {
                    array[i][j] = array[i - 1][j];
                }
            }
        }
        System.out.println(array[K][N]);
    }

    private static int getInteger(String s) {
        return Integer.parseInt(s);
    }
}
