package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 잃어버린괄호 {

    private static List<Integer> minusList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String tmp = "";
        boolean flag = false;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '+' && s.charAt(i) != '-') {
                tmp += s.charAt(i);
            } else {
                result = getResult(tmp, flag, result);
                if (s.charAt(i) == '-') {
                    flag = true;
                }
                tmp = "";
            }
        }
        result = getResult(tmp, flag, result);

        System.out.println(result);
    }

    private static int getResult(String tmp, boolean flag, int result) {
        int a = Integer.parseInt(tmp);
        if (!flag) {
            result += a;
        } else {
            result -= a;
        }
        return result;
    }
}