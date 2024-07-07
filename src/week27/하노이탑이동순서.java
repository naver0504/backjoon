package week27;

import java.util.Scanner;

public class 하노이탑이동순서 {


    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sb.append((int) Math.pow(2, N) - 1).append("\n");

        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }

    static public void hanoi(int n, int start, int mid, int to) {

        if (n == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        hanoi(n - 1, mid, start, to);
    }
}
