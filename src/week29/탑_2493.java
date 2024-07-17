package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_2493 {

    static Stack<Integer> stack = new Stack<>();
    static int[] values;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        values = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i + 1] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        values[0] = Integer.MAX_VALUE;
        stack.push(0);
        for (int i = 1; i <= N; i++) {
            if (values[stack.peek()] > values[i]) {
                sb.append(stack.peek()).append(" ");
                stack.push(i);
            } else {
                while (!stack.isEmpty() && values[stack.peek()] < values[i]) {
                    stack.pop();
                }
                sb.append(stack.peek()).append((" "));
                stack.push(i);
            }
        }
        System.out.println(sb);


    }
}
