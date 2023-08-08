package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 주식11501 {


    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                list.add(input);
            }
            long max = list.get(n - 1);
            long length = 0;
            long tmpSum = 0;
            long result = 0;
            for(int k = 1; k < n; k++) {
                Integer integer = list.get(n - 1 - k);
                if (integer > max) {
                    result += max*length - tmpSum;
                    length = 0;
                    tmpSum = 0;
                    max = integer;
                }
                else {
                    tmpSum += integer;
                    length++;
                }
            }
            result += max*length - tmpSum;
            sb.append(result).append("\n");

        }
        System.out.println(sb);

    }
}
