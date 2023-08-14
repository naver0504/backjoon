package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2 {

    static int[] time;
    static int[] pay;


    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        time = new int[N];
        pay = new int[N];
        int[] result = new int[N+1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (time[i] + i <= N) {
                result[i + time[i]] = Math.max(result[i + time[i]], result[i] + pay[i]);
            }
            result[i+1] = Math.max(result[i+1], result[i]);
        }

        System.out.println(result[N]);
    }
}
