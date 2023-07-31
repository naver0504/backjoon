package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폴리오미노 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (length % 2 != 0) {
                    System.out.println(-1);
                    return;
                } else {
                    int AAAA = length / 4;
                    int BB = length % 4;
                    for (int j = 0; j < AAAA; j++) {
                        sb.append("AAAA");
                    }
                    if (BB == 2) {
                        sb.append("BB");
                    }
                    sb.append(".");
                }
                length = 0;
            } else {
                length++;
            }

        }

        if (length % 2 != 0) {
            System.out.println(-1);
            return;
        }
        int AAAA = length / 4;
        int BB = length % 4;
        for (int j = 0; j < AAAA; j++) {
            sb.append("AAAA");
        }
        if (BB == 2) {
            sb.append("BB");
        }
        System.out.println(sb);
    }
}
