package week24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class 택배상자 {
    class Solution {

        class Box {
            int container;
            int truck;

            Box(int container, int truck) {
                this.container= container;
                this.truck = truck;
            }
        }

        public int solution(int[] order) {
            int answer = 0;
            int length = order.length;
            List<Box> list = new ArrayList<>(length);
            for(int i = 0; i < length; i++) {
                int value = order[i];
                list.add(new Box(value, i + 1));
            }

            list.sort(Comparator.comparingInt(o -> o.container));
            Stack<Integer> stack = new Stack<>();
            int nextOrder = 1;
            for(Box box : list) {
                if(box.truck == nextOrder) {
                    nextOrder++;
                    answer++;
                }  else {
                    while(!stack.isEmpty() && stack.peek() == nextOrder) {
                        nextOrder++;
                        answer++;
                    }

                    stack.push(box.truck);
                }

                while(!stack.isEmpty() && stack.peek() == nextOrder) {
                    nextOrder++;
                    answer++;
                }
            }


            return answer;
        }
    }
}
