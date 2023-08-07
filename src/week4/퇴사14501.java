package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 퇴사14501 {

    static int N;

    static class Day {
        int t;
        int p;

        public Day(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
    static ArrayList<Day> list;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList<Day>(N);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());;
            int p = Integer.parseInt(st.nextToken());;
            list.add(new Day(t, p));
        }
        dfs(0, 0);

        System.out.println(max );
    }

    public static void dfs(int day, int sum) {
        if (day >= N) {
            if(day == N) {
                max = Math.max(max, sum);
            }
            return;
        }
        max = Math.max(max, sum);
        dfs(day + list.get(day).t, sum + list.get(day).p);
        dfs(day + 1, sum);
    }
}
