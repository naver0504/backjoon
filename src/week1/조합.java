package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.math.BigInteger.*;

public class 조합 {
    public static void main(String[] args) throws IOException {
        int n;
        int m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int i = n - m;
        BigInteger left = valueOf(1);
        BigInteger right = valueOf(1);

        if (i < m) {
            int dif = n - m;
            for (int k = 0; k < dif; k++) {
                left = left.multiply(valueOf(n-k));
            }
            while (i >= 1) {
                right = right.multiply(valueOf(i));
                i--;
            }
        } else {
            int dif = n - i;
            for (int k = 0; k < dif; k++) {
                left = left.multiply(valueOf(n-k));
            }
            while (m >= 1) {
                right = right.multiply(BigInteger.valueOf(m));
                m--;
            }
        }
        System.out.println(left.divide(right));

    }
}
