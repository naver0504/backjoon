package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_2805 {

    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        int low = 0;
        int high = trees[N - 1];
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            long treeLength = getTreeLength(mid, trees);
            if (treeLength >= M) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(low);


    }

    public static long getTreeLength(int height, int[] trees) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > height) {
                sum += trees[i] - height;
            }
        }
        return sum;
    }
}
