package week25;

import java.util.HashMap;

public class 롤케이크자르기 {

    class Solution {

        HashMap<Integer, Integer> right = new HashMap<>();
        public int solution(int[] topping) {
            int length = topping.length;
            for(int i = 0; i < length; i++) {
                int top = topping[i];
                int value = right.getOrDefault(top, 0);
                right.put(top, value + 1);
            }
            HashMap<Integer, Integer> left = new HashMap<>();
            int answer = 0;

            for(int i = 0; i < length; i++) {
                int top = topping[i];
                int leftValue = left.getOrDefault(top, 0);
                left.put(top, leftValue + 1);

                int rightValue = right.get(top);
                if(rightValue == 1) {
                    right.remove(top);
                } else {
                    right.put(top, rightValue - 1);
                }

                if(left.size() == right.size()) answer++;
            }
            return answer;
        }
    }
}
