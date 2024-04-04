package week20;

import java.util.Stack;

public class 뒤에있는큰수찾기 {

    class Solution {

        class Node {
            int idx;
            int value;

            Node(int idx, int value) {
                this.idx = idx;
                this.value = value;
            }
        }
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            for(int i = 0; i<numbers.length; i++) answer[i] = -1;

            Stack<Node> stack = new Stack<>();
            stack.push(new Node(0, numbers[0]));

            for(int i = 1; i<numbers.length; i++) {
                while(!stack.isEmpty() && stack.peek().value <numbers[i]) {
                    Node pop = stack.pop();
                    answer[pop.idx] = numbers[i];
                }

                stack.push(new Node(i, numbers[i]));


            }
            return answer;
        }
    }
}
