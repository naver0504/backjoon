package week23;

public class 억억단을외우자 {
    class Solution {
        public int[] solution(int e, int[] starts) {
            int[][] dp = new int[e+1][2];
            int[] division = new int[e + 1];

            for(int i = 1; i<=e; i++) {
                for(int j = i; j <=e; j += i) {
                    division[j]++;
                }
            }
            dp[e][0] = division[e];
            dp[e][1] = e;
            for(int i = e - 1; i >= 1; i--) {
                int value = division[i];
                if(value >= dp[i+1][0]) {
                    dp[i][0] = value;
                    dp[i][1] = i;
                } else {
                    dp[i][0] = dp[i+1][0];
                    dp[i][1] = dp[i+1][1];
                }
            }

            int[] answer = new int[starts.length];
            for(int i = 0; i<starts.length; i++) {
                answer[i] = dp[starts[i]][1];
            }
            return answer;
        }

    }
}
