package week21;

import java.util.ArrayList;
import java.util.List;

public class 인사고과 {

    class Solution {

        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public int solution(int[][] scores) {
            int length = scores.length;

            List<Node> list = new ArrayList<>();
            int youngX = scores[0][0];
            int youngY = scores[0][1];
            int total = youngX + youngY;

            list.add(new Node(youngX, youngY));

            for(int i = 1; i<length; i++) {
                int x = scores[i][0];
                int y = scores[i][1];

                if(x + y <= total) continue;
                if(x > youngX && y > youngY) return -1;

                list.add(new Node(x, y));
            }

            list.sort((o1, o2) -> o1.x != o2.x ? o2.x - o1.x : o1.y - o2.y);

            int maxY = -1;
            int answer = 0;

            for(int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                int x = node.x;
                int y = node.y;

                if(maxY > y) continue;
                else {
                    maxY = y;
                    answer++;
                }


            }

            return list.size() == 0 ? -1 : answer;

        }
    }
}
