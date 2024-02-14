package week14;

import java.util.Scanner;

public class 물병_1052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if (Integer.bitCount(N) <= K) {
            System.out.println(0);
            return;
        }

        int buy = 0;

        while (Integer.bitCount(N++) > K) {
            buy++;
        }
        System.out.println(buy);

    }
}
