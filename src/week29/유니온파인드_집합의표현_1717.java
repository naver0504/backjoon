package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유니온파인드_집합의표현_1717 {

    static int[] set;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            set[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                a = find(a);
                b = find(b);
                if (a == b) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb);
    }


    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if (x < y) {
            set[y] = x;
        } else {
            set[x] = y;
        }
    }

    public static int find(int value) {
        if(set[value] == value){ return value;}
        else{
            return set[value] = find(set[value]);
        }
    }
}
