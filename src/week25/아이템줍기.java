package week25;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {

    class Solution {

        class Node {
            int x;
            int y;
            int count;

            Node(int x, int y, int count) {
                this.x = x;
                this.y = y;
                this.count = count;
            }
        }

        int[][] map = new int[110][110];
        int[] idx = {-1, 0, 1, 0};
        int[] idy = {0, -1, 0, 1};
        int answer = 0;
        boolean[][] visited = new boolean[110][110];
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            for(int i = 0; i < rectangle.length; i++) {
                int firstX = rectangle[i][0] * 2;
                int firstY = rectangle[i][1] * 2;
                int lastX = rectangle[i][2] * 2;
                int lastY = rectangle[i][3] * 2;

                int row = lastX - firstX;
                int col = lastY - firstY;

                for(int j = 0; j <= row; j++) {
                    for(int k = 0; k <= col; k++) {
                        int x = firstX + j;
                        int y = firstY + k;
                        if(isEdge(firstX, firstY, lastX, lastY, x, y)) {
                            if(map[x][y] != 2) {
                                map[x][y] = 1;
                            }
                        } else {
                            map[x][y] = 2;
                        }
                    }
                }
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(characterX * 2, characterY * 2, 0));
            visited[characterX * 2][characterY * 2] = true;

            while(!queue.isEmpty()) {
                Node poll = queue.poll();
                if(poll.x == itemX * 2 && poll.y == itemY * 2) {
                    return poll.count / 2;
                }

                for(int i = 0; i < 4; i++) {
                    int ndx = poll.x + idx[i];
                    int ndy = poll.y + idy[i];
                    if(!isValidRange(ndx, ndy)) continue;
                    if(map[ndx][ndy] != 1) continue;
                    if(visited[ndx][ndy]) continue;

                    visited[ndx][ndy] = true;
                    queue.offer(new Node(ndx, ndy, poll.count + 1));

                }
            }
            return 0;
        }

        public boolean isValidRange(int x, int y) {
            if(x < 0 || y < 0 || x >= 110 || y >= 110) return false;
            return true;
        }

        public boolean isEdge(int firstX, int firstY, int lastX, int lastY, int x, int y) {
            if(x == firstX || x == lastX) return true;
            if(y == firstY || y == lastY) return true;
            return false;
        }
    }
}
