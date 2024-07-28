package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클게임_20040 {


    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            x = find(x);
            y = find(y);
            if (x == y) {
                System.out.println(i + 1);
                return;
            }
            union(x, y);
        }
        System.out.println(0);

    }

    public static int find(int x) {
        if(x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }
}
