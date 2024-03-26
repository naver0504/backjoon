package week19;

public class 덧칠하기 {

    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer= 0;
            int start = 0;
            int end = 0;

            for(int s : section) {
                if(s < start || s > end){
                    answer++;
                    start = s;
                    end = s + m - 1;
                }
            }
            return answer;
        }
    }
}
