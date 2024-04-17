package week22;

public class 점찍기 {
    class Solution {
        public long solution(int k, int d) {
            long answer = 0;

            double powD = Math.pow(d, 2);

            for(int i = 0; i <= d; i += k) {
                double powI = Math.pow(i, 2);

                int y = (int) Math.sqrt(powD - powI);
                answer += y/k + 1;
            }
            return answer;
        }
    }
}
