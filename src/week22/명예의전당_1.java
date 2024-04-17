package week22;

import java.util.PriorityQueue;

public class 명예의전당_1 {

    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            int idx = 0;

            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

            for(int scr : score) {
                queue.add(scr);
                if(queue.size() > k) {
                    queue.poll();
                }

                answer[idx++] = queue.peek();
            }

            return answer;
        }
    }
}
