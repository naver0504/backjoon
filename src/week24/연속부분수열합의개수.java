package week24;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {
    class Solution {

        Set<Integer> set = new HashSet<>();

        public int solution(int[] elements) {
            int range = 1;
            while(range <= elements.length) {
                for(int i = 0; i < elements.length; i++) {
                    int sum = 0;
                    for(int j = 0; j < range; j++) {
                        sum += elements[(i + j) % elements.length];
                    }
                    set.add(sum);
                }

                range++;
            }
            return set.size();
        }
    }
}
