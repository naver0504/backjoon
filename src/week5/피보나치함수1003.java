package week5;

import java.util.Scanner;

public class 피보나치함수1003 {

    static int N;

    static class ZeroOne {

        long zero;
        long one;

        public ZeroOne(long zero, long one) {
            this.zero = zero;
            this.one = one;
        }
    }

    static ZeroOne[] arr = new ZeroOne[41];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        arr[0] = new ZeroOne(1, 0);
        arr[1] = new ZeroOne(0, 1);
        for (int i = 2; i < 41; i++) {
            arr[i] = new ZeroOne(arr[i - 1].zero + arr[i - 2].zero, arr[i - 1].one + arr[i - 2].one);
        }

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num == 0) {
                sb.append(1).append(" ").append(0).append("\n");
                continue;
            }
            else if(num == 1) {
                sb.append(0).append(" ").append(1).append("\n");
                continue;
            }
             sb.append(arr[num].zero).append(" ").append(arr[num].one).append("\n");


        }

        System.out.println(sb);
    }
}
