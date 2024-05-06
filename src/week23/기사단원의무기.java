package week23;

public class 기사단원의무기 {
    class Solution {

        int[] dp;
        public int solution(int number, int limit, int power) {

            dp = new int[number+1];

            for(int i = 1; i <= number; i++) {
                for(int j = 1; i * j <= number; j++) {
                    dp[i * j]++;
                }
            }

            int answer = 0;


            for(int i = 1; i <= number; i++) {
                if(dp[i] >limit) {
                    answer += power;
                    continue;
                }

                answer += dp[i];
            }
            return answer;
        }
    }
}
