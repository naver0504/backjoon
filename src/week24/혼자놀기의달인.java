package week24;

import java.util.HashSet;
import java.util.Set;

public class 혼자놀기의달인 {

    class Solution {
        public int solution(int[] cards) {
            int answer = 0;

            for(int i = 0; i < cards.length; i++) {
                answer = Math.max(answer, chooseBox(i, cards));
            }

            return answer;
        }

        private int chooseBox(int index, int[] cards) {
            Set<Integer> first = new HashSet<>();
            chooseFirstBox(index, cards, first);

            if(first.size() == cards.length) return 0;
            int secondSize = Integer.MIN_VALUE;
            for(int i = 0; i < cards.length; i++) {
                if(first.contains(cards[i])) continue;
                secondSize = Math.max(secondSize, chooseSecondBox(i, cards, first));
            }
            return first.size() * secondSize;

        }

        private void chooseFirstBox(int index, int[] cards, Set<Integer> first) {
            while(first.size() != cards.length) {
                int value = cards[index];
                if(first.contains(value)) {
                    break;
                }
                index = value - 1;
                first.add(value);
            }
        }

        private int chooseSecondBox(int index, int[] cards, Set<Integer> first) {
            Set<Integer> second = new HashSet<>();
            while(true) {
                int value = cards[index];
                if(first.contains(value) || second.contains(value)) {
                    break;
                }
                index = value - 1;
                second.add(value);
            }
            return second.size();
        }}
}
