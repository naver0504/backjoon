package week22;

import java.util.PriorityQueue;

public class 디펜스게임 {
    class Solution {
        public int solution(int n, int k, int[] enemy) {

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int answer = 0;

            for(int ene : enemy) {
                if(queue.size() < k) {
                    queue.add(ene);
                    answer++;
                } else {
                    queue.add(ene);
                    int value = queue.poll();
                    if(value > n) {
                        break;
                    }
                    n -= value;
                    answer++;
                }
            }
            return answer;
        }
    }
}
