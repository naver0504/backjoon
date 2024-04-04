package week20;

import java.util.Arrays;

public class 숫자변환하기 {

    class Solution {

        int[] dp;
        int max = 1_000_000;
        public int solution(int x, int y, int n) {
            dp = new int[y + 1];
            Arrays.fill(dp, max);
            dp[x] = 0;
            for(int i = x; i < y; i++) {
                if(i + n <= y) {
                    dp[i + n] = Math.min(dp[i] + 1, dp[i+n]);
                }

                if(i * 2 <= y) {
                    dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
                }

                if(i * 3 <= y) {
                    dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
                }

            }
            return dp[y] == max ? -1 : dp[y];
        }
    }
}
