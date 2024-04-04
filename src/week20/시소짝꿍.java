package week20;

import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍 {

    class Solution {


        int ZERO = 0;
        Map<Double, Integer> map = new HashMap<>();
        public long solution(int[] weights) {
            for(int i = 0; i<weights.length; i++) {
                double weight = Double.valueOf(weights[i]);

                if(map.containsKey(weight)) {
                    int count = map.get(weight);
                    map.put(weight, count + 1);
                } else {
                    map.put(weight, 1);
                }
            }
            long answer = 0;
            for(double weight : map.keySet()) {
                long value = map.get(weight);
                answer += value * (value - 1) / 2;
                answer += value * map.getOrDefault(weight * 1.5, ZERO);
                answer += value * map.getOrDefault(weight * 2, ZERO);
                answer += value * map.getOrDefault(weight * 4 / 3, ZERO);
            }


            return answer;
        }
    }
}
