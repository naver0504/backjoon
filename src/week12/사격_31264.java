package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class 사격_31264 {

    static int N;
    static int M;
    static int A;
    static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());


        s = new int[N];
        for (int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(s);
        int start = 0;
        int end = s[N - 1];

        while (start + 1 <  end) {
            int mid = (start + end) / 2;
            if (isPossible(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        System.out.println(end);



    }

    private static boolean isPossible(int ability) {
        int idx = 0;
        while (idx + 1 < N && s[idx+1] <= ability) {
            idx++;
        }

        if (ability < s[idx]) {
            return false;
        }

        long currentA = 0;
        for (int i = 0; i < M; i++) {
            currentA += s[idx];
            ability += s[idx];

            while (idx + 1 < N && s[idx+1] <= ability) {
                idx++;
            }

        }
        return currentA >= A;
    }

}
