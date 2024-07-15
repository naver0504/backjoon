package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 리모컨_1107 {


    static boolean[] canPush = new boolean[10];
    static int N;
    static int minDfsDif = 500000;
    static int minDfsDepth = 0;
    static int nDigit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arrays.fill(canPush, true);
        int M = Integer.parseInt(br.readLine());
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                canPush[Integer.parseInt(st.nextToken())] = false;
            }
        }
        nDigit = String.valueOf(N).length();

        dfs(0, 0);

        System.out.println(Math.min(Math.abs(100 - N), minDfsDif + minDfsDepth));
    }

    private static void dfs(int depth, int value) {
        int dif = Math.abs(value - N);
        if(depth != 0 && depth + dif < minDfsDepth + minDfsDif) {
            minDfsDif = dif;
            minDfsDepth = depth;
        }

        if (depth > 6 || depth >= nDigit + 2) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!canPush[i]) continue;
            dfs(depth + 1, value * 10 + i);
        }


    }
}
