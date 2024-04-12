package week21;

import java.util.ArrayList;
import java.util.List;

public class 테이블해시함수 {

    class Solution {

        public int solution(int[][] data, int col, int row_begin, int row_end) {

            List<int[]> list = new ArrayList<>(data.length);

            for(int i = 0; i <data.length; i++) {
                list.add(data[i]);
            }

            list.sort((o1, o2) -> {
                if(o1[col - 1] == o2[col - 1]) return o2[0] - o1[0];
                else return o1[col - 1] - o2[col - 1];
            });

            int[] answer = new int[row_end - row_begin + 1];
            int idx = 0;
            for(int i = row_begin; i <= row_end; i++) {
                int sum = 0;
                int[] s = list.get(i - 1);
                for(int j = 0; j < s.length; j++) {
                    sum += s[j] % i;
                }
                answer[idx++] = sum;
            }

            int ans = answer[0];
            for(int i = 1; i < answer.length; i++) {
                ans ^= answer[i];
            }
            return ans;
        }
    }
}
