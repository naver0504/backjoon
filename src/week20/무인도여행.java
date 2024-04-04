package week20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 무인도여행 {

    class Solution {

        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[][] map;
        int row;
        int col;
        boolean[][] visited;
        List<Integer> answer = new ArrayList<>();

        int[] idx = {-1, 1, 0, 0};
        int[] idy = {0, 0, -1, 1};

        public int[] solution(String[] maps) {
            row = maps.length;
            col = maps[0].length();
            map = new int[row][col];
            visited = new boolean[row][col];

            for(int i = 0; i<row; i++) {
                String line = maps[i];
                for(int j = 0; j < col; j++) {
                    char c = line.charAt(j);
                    if(c == 'X') map[i][j] = 0;
                    else map[i][j] = Integer.valueOf(c) - '0';
                }
            }

            for(int i = 0; i<row; i++) {
                for(int j = 0; j < col; j++) {
                    if(!visited[i][j] && map[i][j] != 0) {
                        bfs(i, j);
                    }
                }
            }

            answer.sort((o1, o2) -> o1 - o2);

            if(answer.size() != 0) {
                return answer.stream().mapToInt(Integer::intValue).toArray();
            } else {
                return new int[] {-1};
            }

        }

        public void bfs(int startX, int startY) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(startX, startY));
            visited[startX][startY] = true;

            int sum = map[startX][startY];

            while(!queue.isEmpty()) {
                Node node = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int ndx = node.x + idx[i];
                    int ndy = node.y + idy[i];

                    if(!isValidRange(ndx, ndy)) continue;
                    if(map[ndx][ndy] == 0) continue;
                    if(visited[ndx][ndy]) continue;

                    visited[ndx][ndy] = true;
                    sum += map[ndx][ndy];

                    queue.add(new Node(ndx, ndy));
                }
            }

            answer.add(sum);
        }

        public boolean isValidRange(int x, int y) {
            if(x < 0 || y < 0 || x >= row || y>= col) return false;
            return true;
        }
    }
}
