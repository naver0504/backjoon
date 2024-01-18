package week11;

import java.util.Scanner;

public class 소수팰린드롬_1747 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();

        while(true) {
            if(isPalindrome(N) && isPrime(N)) {
                break;
            }
            N++;
        }

        System.out.println(N);
    }

    private static boolean isPalindrome(long n) {
        String str = String.valueOf(n);
        for (int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) == str.charAt(str.length() - i - 1)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isPrime(long n) {
        if(n == 1) {
            return false;
        }
        else if (n == 2) {
            return true;
        } else {
            for(int i = 2; i<=Math.sqrt(n); i++) {
                if(n % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
