package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 로또6603 {

    static StringBuilder sb = new StringBuilder();

    static boolean[] visited;
    static int[] num;
    static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }
            visited = new boolean[K];
            num = new int[K];
            for (int i = 0; i < K; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int start, int depth) {

        if (depth == 6) {
            for (int i = 0; i < K; i++) {
                if (visited[i]) {
                    sb.append(num[i] + " ");
                }
            }
            sb.append("\n");
        }
        for (int i = start; i < K; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;

        }


    }
}
