package week26;

import java.util.*;

public class 석유시추 {

    class Solution {

        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        int[] idx = {1, -1, 0, 0};
        int[] idy = {0, 0, 1, -1};

        int[][][] map;
        int cur = 1;
        int row;
        int col;
        public int solution(int[][] land) {
            int answer = 0;
            row = land.length;
            col = land[0].length;
            map = new int[land.length][land[0].length][2];

            for(int i = 0; i < land.length; i++) {
                for(int j = 0; j < land[0].length; j++) {
                    if(land[i][j] == 0) continue;
                    if(map[i][j][0] != 0) continue;

                    int amount = 0;
                    Queue<Node> queue = new LinkedList<>();
                    List<Node> list = new ArrayList<>();
                    queue.offer(new Node(i, j));
                    map[i][j][0] = 1;
                    while(!queue.isEmpty()) {
                        Node poll = queue.poll();
                        list.add(poll);
                        amount++;
                        for(int k = 0; k < 4; k++) {
                            int ndx = poll.x + idx[k];
                            int ndy = poll.y + idy[k];
                            if(ndx < 0 || ndy < 0 || ndx >= row || ndy >= col) continue;
                            if(land[ndx][ndy] == 0) continue;
                            if(map[ndx][ndy][0] != 0) continue;

                            map[ndx][ndy][0] = 1;
                            queue.offer(new Node(ndx, ndy));
                        }
                    }

                    for(Node node : list) {
                        map[node.x][node.y][0] = list.size();
                        map[node.x][node.y][1] = cur;
                    }
                    cur++;
                }
            }



            for(int i = 0; i < col; i++) {
                Set<Integer> set = new HashSet<>();
                int sum = 0;
                for(int j = 0; j < row; j++) {
                    if(map[j][i][0] == 0) continue;
                    if(set.contains(map[j][i][1])) continue;
                    sum += map[j][i][0];
                    set.add(map[j][i][1]);
                }
                answer = Math.max(sum, answer);
            }

            return answer;
        }
    }
}
