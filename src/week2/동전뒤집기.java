package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전뒤집기 {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int bit = 0; bit < (1 << N); bit++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int T = 0;
                for (int i = 0; i < N; i++) {
                    char c = arr[i][j];
                    if ((bit & (1 << i)) != 0) {
                        if(c == 'T')
                            c = 'H';
                        else
                            c = 'T';
                    }
                    if (c == 'T') {
                        T++;
                    }
                }
                sum += Math.min(T, N - T);
            }
            result = Math.min(sum, result);
        }
        System.out.println(result);
    }
}