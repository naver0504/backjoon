package week19;

import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {
    class Solution {

        Map<Character, Integer> map = new HashMap<>();
        public int[] solution(String[] keymap, String[] targets) {

            for(String key : keymap) {
                for(int i = 0; i < key.length(); i++) {
                    char c = key.charAt(i);
                    if(!map.containsKey(c)) {
                        map.put(c, i +1);
                    } else {
                        int org = map.get(c);
                        if(org > i) {
                            map.put(c, i + 1);
                        }
                    }

                }
            }

            int[] answer = new int[targets.length];
            int idx = 0;

            for(String target : targets) {
                int sum = 0;
                for(int i = 0; i<target.length(); i++) {
                    char c = target.charAt(i);
                    if(map.containsKey(c)) {
                        sum += map.get(c);
                    } else {
                        answer[idx++] = -1;
                        sum = -1;
                        break;
                    }
                }

                if(sum != -1) answer[idx++] = sum;

            }

            return answer;
        }
    }
}
