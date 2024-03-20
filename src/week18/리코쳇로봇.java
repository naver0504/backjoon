package week18;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {
    class Solution {

        int[] idx = {-1, 1, 0, 0};
        int[] idy = {0, 0, -1, 1};

        int startX;
        int startY;

        int goalX;
        int goalY;

        int row;
        int col;
        int[][] map;


        class Node {
            int x;
            int y;
            int count;
            int preDir;

            Node(int x, int y, int count, int preDir) {
                this.x = x;
                this.y = y;
                this.count = count;
                this.preDir = preDir;
            }
        }

        public int solution(String[] board) {
            int answer = 0;
            row = board.length;
            col = board[0].length();
            map = new int[row][col];

            for (int i = 0; i < row; i++) {
                String line = board[i];
                for (int j = 0; j < col; j++) {
                    switch (line.charAt(j)) {
                        case 'D' -> map[i][j] = 0;
                        case 'G' -> {
                            map[i][j] = 1;
                            goalX = i;
                            goalY = j;
                        }
                        case 'R' -> {
                            map[i][j] = 1;
                            startX = i;
                            startY = j;
                        }
                        default -> map[i][j] = 1;
                    }
                }
            }

            if (!isCanBeGoal()) return -1;

            Queue<Node> queue = new LinkedList<>();
            boolean[][] visited = new boolean[row][col];
            visited[startX][startY] = true;
            queue.add(new Node(startX, startY, 0, -1));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.x == goalX && node.y == goalY) return node.count;
                for (int dir = 0; dir < 4; dir++) {
                    if (dir == node.preDir) continue;
                    int[] xy = getXY(node.x, node.y, dir);
                    if (visited[xy[0]][xy[1]]) continue;
                    visited[xy[0]][xy[1]] = true;
                    queue.add(new Node(xy[0], xy[1], node.count + 1, dir));
                }

            }

            return -1;

        }


        private int[] getXY(int x, int y, int dir) {
            int[] xy = new int[2];

            while (true) {
                int nextX = x + idx[dir];
                int nextY = y + idy[dir];

                if (isOutOfIndex(nextX, nextY) || map[nextX][nextY] == 0) {
                    xy[0] = x;
                    xy[1] = y;
                    break;
                }

                x = nextX;
                y = nextY;
            }

            return xy;

        }

        private boolean isCanBeGoal() {
            for (int i = 0; i < 4; i++) {
                int x = goalX + idx[i];
                int y = goalY + idy[i];
                if (isOutOfIndex(x, y) || map[x][y] == 0) return true;
            }
            return false;
        }

        private boolean isOutOfIndex(int x, int y) {
            if (x < 0 || y < 0 || x >= row || y >= col) return true;
            return false;
        }
    }
}
