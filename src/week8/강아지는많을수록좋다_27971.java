package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 강아지는많을수록좋다_27971 {

    static class Node{
        int L;
        int R;

        public Node(int l, int r) {
            L = l;
            R = r;
        }

        public boolean isInside(int dogs) {
            if (L <= dogs && dogs <= R) {
                return true;
            }
            return false;
        }
    }

    public static int N;
    public static int M;
    public static int A;
    public static int B;
    public static Node[] nodes;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        dp[0] = 1;
        nodes = new Node[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(l, r);
        }

        for (int i = 0; i < M; i++) {
            boolean insideA = nodes[i].isInside(A);
            if(!insideA) dp[A] = 2;
            boolean insideB = nodes[i].isInside(B);
            if(!insideB) dp[B] = 2;
        }
        int min = Math.min(A, B);
        for (int i = min+1; i <= N; i++) {
            DP(i);
        }
        System.out.println(dp[N] == 0 ? -1 : dp[N] - 1);
    }

    private static void DP(int dogs) {

        for (int i = 0; i < M; i++) {
            boolean inside = nodes[i].isInside(dogs);
            if(inside) return;
        }

        int dpA = Integer.MAX_VALUE;
        if (dogs - A >= 0 && dp[dogs-A] != 0) {
            dpA = dp[dogs-A] + 1;
        }

        int dpB = Integer.MAX_VALUE;
        if (dogs - B >= 0 && dp[dogs-B] != 0) {
            dpB = dp[dogs-B] + 1;
        }
        if(dpA == Integer.MAX_VALUE && dpB == Integer.MAX_VALUE) return;
        dp[dogs] = Math.min(dpA, dpB);
    }

}
