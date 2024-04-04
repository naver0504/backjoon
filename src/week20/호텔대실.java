package week20;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실 {

    class Solution {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        public int solution(String[][] book_time) {

            int[][] time = new int[book_time.length][2];

            for(int i = 0; i<book_time.length; i++) {

                int startHour = Integer.valueOf(book_time[i][0].substring(0, 2)) * 60;
                int startMinute = Integer.valueOf(book_time[i][0].substring(3));

                int endHour = Integer.valueOf(book_time[i][1].substring(0, 2)) * 60;
                int endMinute = Integer.valueOf(book_time[i][1].substring(3)) + 10;



                time[i][0] = startHour + startMinute;
                time[i][1] = endHour + endMinute;

            }

            Arrays.sort(time, (o1, o2) -> {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            });


            queue.add(time[0][1]);

            for(int i = 1; i<book_time.length; i++) {

                if(queue.peek() <= time[i][0]) {
                    queue.poll();
                }

                queue.add(time[i][1]);

            }
            return queue.size();
        }
    }
}
