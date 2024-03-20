package week18;

import java.util.Arrays;
import java.util.Stack;

public class 과제진행하기 {

    class Solution {

        class Node {

            String name;
            int leftTime;

            Node(String name,  int leftTime) {

                this.name = name;
                this.leftTime = leftTime;

            }

        }

        Stack<Node> stack = new Stack<>();

        public String[] solution(String[][] plans) {
            Arrays.sort(plans, (s1, s2) -> s1[1].compareTo(s2[1]));

            String[] answer = new String[plans.length];
            int idx = 0;
            for(int i = 0; i < plans.length - 1; i++) {
                String[] plan = plans[i];
                String name = plan[0];
                int hour = Integer.parseInt(plan[1].substring(0, 2));
                int minutes = Integer.parseInt(plan[1].substring(3));
                int time = Integer.parseInt(plan[2]);
                minutes += hour * 60;

                String[] nextPlan = plans[i + 1];
                String nextName = plan[0];
                int nextHour = Integer.parseInt(nextPlan[1].substring(0, 2));
                int nextMinutes = Integer.parseInt(nextPlan[1].substring(3));
                nextMinutes += 60 * nextHour;

                if(nextMinutes - minutes < time) {
                    stack.push(new Node(name ,time - (nextMinutes - minutes)));
                } else {
                    answer[idx++] = name;
                    int leftTime = nextMinutes - minutes - time;
                    if(stack.isEmpty()) continue;
                    while(!stack.isEmpty()) {
                        Node node = stack.pop();
                        if(node.leftTime > leftTime) {
                            stack.push(new Node(node.name, node.leftTime - leftTime));
                            break;
                        }  else {
                            answer[idx++] = node.name;
                            leftTime -= node.leftTime;
                        }
                    }
                }

            }

            answer[idx++] = plans[plans.length - 1][0];

            while(!stack.isEmpty()) {
                Node node = stack.pop();
                answer[idx++] = node.name;
            }
            return answer;
        }
    }
}
