package week6;

import java.util.Scanner;
import java.util.Stack;

public class LCS2_9252 {
    public static int[][] dp;


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String output = sc.nextLine();
        String result = "";
        dp = new int[input.length() + 1][output.length() + 1];

        for(int i = 0; i < input.length(); i++) {
            for(int j = 0; j < output.length(); j++) {
                if(input.charAt(i) == output.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(dp[input.length()][output.length()]);
        Stack<Character> stack = new Stack<>();
        int i = input.length();
        int j = output.length();
        while(i != 0 && j != 0) {
            if(dp[i][j] == dp[i-1][j]) {
                i--;
            } else if(dp[i][j] == dp[i][j-1]) {
                j--;
            } else {
                stack.push(input.charAt(i-1));
                i--;
                j--;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
