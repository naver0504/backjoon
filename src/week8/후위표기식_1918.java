package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식_1918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int len = str.length();
        for (int i = 0; i < len; i++) {
            char now = str.charAt(i);

            switch (now){
                case '+', '-', '*', '/' -> {
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(now)) {
                        sb.append(stack.pop());
                    }
                    stack.add(now);
                }
                case '(' -> stack.add(now);

                case ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default ->
                    sb.append(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    public static int getPriority(char operator){

        return switch (operator){
            case '(', ')' -> 0;
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };

    }

}
