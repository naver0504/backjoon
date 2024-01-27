package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 전화번호목록_5052 {




    static final String YES = "YES";
    static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            String[] array = new String[n];
            for (int j = 0; j < n; j++) {
                array[j] = br.readLine();
            }
            Arrays.sort(array);

            for (int j = 0; j < n - 1; j++) {
                if (array[j + 1].startsWith(array[j])) {
                    flag = false;
                    break;

                }
            }

            if(flag) sb.append(YES);
            else sb.append(NO);
            sb.append("\n");

        }

        System.out.println(sb);
    }
}
