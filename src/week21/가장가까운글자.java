package week21;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운글자 {

    class Solution {

        Map<Character, Integer> map = new HashMap<>();
        public int[] solution(String s) {
            int[] answer = new int[s.length()];

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(map.containsKey(c)) {
                    int idx = map.get(c);
                    int newIdx = i - idx;
                    answer[i] = newIdx;
                } else {
                    answer[i] = -1;
                }

                map.put(c, i);

            }
            return answer;
        }
    }
}
