package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Contact_1013 {

    static String YES = "YES";
    static String NO = "NO";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            boolean matches = Pattern.matches("(100+1+|01)+", line);
            if(matches) sb.append(YES).append("\n");
            else sb.append(NO).append("\n");
        }
        System.out.println(sb);
    }

}
