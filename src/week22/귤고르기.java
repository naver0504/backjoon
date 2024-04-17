package week22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기 {

    class Solution {

        Map<Integer, Integer> map = new HashMap<>();

        class Node {
            int weight;
            int count;

            Node(int weight, int count) {
                this.weight = weight;
                this.count = count;
            }
        }

        public int solution(int k, int[] tangerine) {

            for(int tan : tangerine) {
                map.put(tan, map.getOrDefault(tan, 0) + 1);
            }

            List<Integer> list = new ArrayList<>(map.values());


            list.sort((o1, o2) -> o2 - o1);
            int answer = 0;

            for(int count : list) {
                answer++;
                if( k <= count) {
                    break;
                }
                k -= count;
            }

            return answer;
        }
    }
}
