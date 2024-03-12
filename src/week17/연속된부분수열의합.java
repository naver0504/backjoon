package week17;

public class 연속된부분수열의합 {
    class Solution {

        int minLength = Integer.MAX_VALUE;

        public int[] solution(int[] sequence, int k) {

            int n = sequence.length;
            int sum = 0;
            int[] answer = new int[2];
            for(int l = 0, r = 0; l < n; l++) {
                while(r < n && sum < k) {
                    sum += sequence[r++];
                }


                if(sum == k) {
                    if(r - l < minLength) {
                        minLength = r - l;
                        answer[0] = l;
                        answer[1] = r - 1;
                    }
                }

                sum -= sequence[l];
            }


            return answer;
        }
    }
}
