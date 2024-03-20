package week18;

import java.util.ArrayList;
import java.util.List;

public class 광물캐기 {
    class Solution {
        class Node {
            int value;
            List<String> list;

            Node(int value, List<String> list) {
                this.value = value;
                this.list = list;
            }
        }

        List<Node> nodes = new ArrayList<>();

        public int solution(int[] picks, String[] minerals) {

            int answer = 0;
            int length = minerals.length;
            int idx= 0;

            int pick = 0;

            for(int i = 0; i < picks.length; i++)
                pick += picks[i];

            for(int i = 0; i < length / 5 && pick > 0; i++) {
                int sum = 0;
                List<String> list = new ArrayList<>();
                for(int j = 0; j < 5; j++) {
                    sum += getValue(minerals[idx]);
                    list.add(minerals[idx++]);
                }

                nodes.add(new Node(sum, list));
                pick--;
            }


            if(pick > 0){

                int sum = 0;
                List<String> list = new ArrayList<>();

                while(idx < length) {
                    sum += getValue(minerals[idx]);
                    list.add(minerals[idx++]);
                }
                nodes.add(new Node(sum, list));
            }

            nodes.sort((n1, n2) -> n2.value - n1.value);

            for(Node node : nodes) {
                if(picks[0] > 0) {
                    answer += node.list.size();
                    picks[0]--;
                } else if(picks[1] > 0) {
                    for(String mineral : node.list) {
                        if(mineral.equals("diamond")) {
                            answer += 5;
                        } else {
                            answer++;
                        }
                    }
                    picks[1]--;
                } else if(picks[2] > 0) {
                    answer += node.value;
                    picks[2]--;
                } else {
                    break;
                }
            }


            return answer;

        }

        private int getValue(String mineral) {
            return switch(mineral) {
                case "diamond" ->  25;
                case "iron" ->  5;
                default ->  1;
            };
        }
    }
}
