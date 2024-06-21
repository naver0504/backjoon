package week25;

import java.util.*;

public class 주차요금계산 {

    class Solution {

        class Node {
            int carNum;
            int value;

            Node(int carNum, int value) {
                this.carNum = carNum;
                this.value = value;
            }
        }

        int maxMinute = 60 * 23 + 59;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        public int[] solution(int[] fees, String[] records) {

            for(int i = 0; i < records.length; i++) {
                String[] record = records[i].split(" ");
                int minute = convertTimeToMinute(record[0]);
                int carNum = Integer.valueOf(record[1]);
                Queue<Integer> queue = map.getOrDefault(carNum, new LinkedList<>());
                queue.offer(minute);
                map.put(carNum, queue);
            }

            List<Node> nodes = new ArrayList<>();
            for(int key : map.keySet()) {
                Queue<Integer> queue = map.get(key);
                int sumMinute = 0;
                int size = queue.size();
                for(int i = 0; i < size / 2; i++) {
                    int in = queue.poll();
                    int out = queue.poll();
                    sumMinute += out - in;
                }

                if(size % 2 != 0) sumMinute += maxMinute - queue.poll();
                if(sumMinute <= fees[0]) nodes.add(new Node(key, fees[1]));
                else {
                    int tmp = (int) Math.ceil((sumMinute - fees[0]) / (double) fees[2]);
                    int value = fees[1] + tmp * fees[3];
                    nodes.add(new Node(key, value));
                }
            }

            return nodes.stream().sorted(Comparator.comparingInt(n -> n.carNum))
                    .mapToInt(node -> node.value).toArray();
        }

        public int convertTimeToMinute(String time) {
            String[] times = time.split(":");
            return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
        }
    }
}
