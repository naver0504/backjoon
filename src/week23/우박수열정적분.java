package week23;

import java.util.ArrayList;
import java.util.List;

public class 우박수열정적분 {
    class Solution {

        List<Integer> list = new ArrayList<>();
        public double[] solution(int k, int[][] ranges) {

            list.add(k);

            while(k != 1) {
                if(k % 2 == 0) {
                    k = k / 2;
                } else {
                    k = 3*k + 1;
                }
                list.add(k);
            }

            int n = list.size() - 1;
            double[] square = new double[n];

            for(int i = 0; i < list.size() - 1; i++) {
                int left = list.get(i);
                int right = list.get(i + 1);
                square[i] = (left + right) / 2.0;
            }


            double[] answer = new double[ranges.length];
            for(int i = 0; i< ranges.length; i++) {
                int left = ranges[i][0];
                int right = n + ranges[i][1];

                if(left > right) {
                    answer[i] = -1.0;
                } else if(left == right) {
                    answer[i] = 0.0;
                } else {
                    double sum = 0.0;
                    for(int j = left; j < right; j++) {
                        sum += square[j];
                    }
                    answer[i] = sum;
                }
            }
            return answer;
        }
    }
}
