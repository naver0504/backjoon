package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AB16953 {


    public static int MIN = Integer.MAX_VALUE;
    public static int B;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        getResult(A, 0);
        if(MIN == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(MIN+1);

    }

    private static void getResult(long A, int count) {
        if (A == B) {
            MIN = Math.min(MIN, count);
            return;
        } else {
            if(A>B) {
                return;
            }

            getResult(A*2, count+1);
            getResult(A*10+1, count+1);
        }
    }
}
