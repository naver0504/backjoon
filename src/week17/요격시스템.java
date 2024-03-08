package week17;

import java.util.Arrays;

public class 요격시스템 {

    class Solution {
        public int solution(int[][] targets) {
            int answer = 0;

            Arrays.sort(targets, (o1, o2) -> {
                        if(o1[0] != o2[0]) return o1[0] - o2[0];
                        else return o1[1] - o2[1];
                    }
            );

            int peek = 0;
            for(int i = 0; i<targets.length; i++) {
                int start = targets[i][0];
                int end = targets[i][1];

                if(peek <= start) {
                    answer++;
                    peek = end;
                    continue;
                }

                if(end <= peek) peek = end;


            }

            return answer;
        }
    }
}
