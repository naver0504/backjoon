package week23;

import java.util.ArrayList;
import java.util.List;

public class 과일장수 {
    class Solution {



        public int solution(int k, int m, int[] score) {

            List<Integer> list = new ArrayList<>();
            for(int i = 0; i< score.length; i++) {
                list.add(score[i]);
            }

            list.sort((o1, o2) -> o2 - o1);
            int answer = 0;

            for(int i = m - 1; i < list.size(); i+= m) {
                answer += list.get(i) * m;
            }

            return answer;
        }
    }
}
