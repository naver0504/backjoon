package week17;

import java.util.HashMap;

public class 추억점수 {

    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {

            HashMap<String, Integer> map = new HashMap<>();

            for(int i = 0; i<name.length; i++) {
                map.put(name[i], yearning[i]);
            }

            int[] answer = new int[photo.length];
            for(int i = 0; i<photo.length; i++) {
                int sum = 0;
                for(int j = 0; j<photo[i].length; j++) {
                    String key = photo[i][j];
                    if(map.containsKey(key)) sum += map.get(key);
                }
                answer[i] = sum;

            }

            return answer;
        }
    }
}
