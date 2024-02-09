package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {

    static int n;
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(getResult(n, r, c));





    }

    private static long getResult(int n, long r, long c) {
        if(n == 0) {
            return 0;
        }

        long length = (long) Math.pow(2, n);
        long root = length / 2;
        if (r < root && c < root) {
            return getResult(n - 1, r, c);
        } else if (r < root && c >= root) {
            return getResult(n  - 1, r, c - root) + root * root;
        } else if (r >= root && c < root) {
            return getResult(n  - 1, r - root, c) + root * root * 2;
        } else {
            return getResult(n - 1, r - root, c - root) + root * root * 3;
        }

    }
}
