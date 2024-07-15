package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 투포인터_부분합_1806 {

    static int[] arr;
    static int N;
    static int S;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        while (sum >= S || right != N) {
            if (sum < S) {
                sum += arr[++right];
            } else {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }

        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);


    }
}
