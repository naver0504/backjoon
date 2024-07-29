package week31;

import java.util.*;

public class 단어수학_1339 {

    static int[] alphas = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            int digit = 1;
            for (int j = 0; j <word.length() - 1; j++) {
                digit *= 10;
            }
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                alphas[c - 'A'] += digit;
                digit /= 10;
            }
        }
        int sum = 0;
        Arrays.sort(alphas);
        int cur = 9;
        for (int i = 25; i >= 0 ; i--) {
            if(alphas[i] == 0) break;
            sum += alphas[i] * cur;
            cur--;
        }

        System.out.println(sum);
    }

}
