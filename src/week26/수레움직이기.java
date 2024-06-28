package week26;

public class 수레움직이기 {

    class Solution {

        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Node redFirst;
        Node redGoal;

        Node blueFirst;
        Node blueGoal;
        int row;
        int col;
        int[][] map;
        int answer = Integer.MAX_VALUE;
        int RED = 0;
        int BLUE = 1;

        int[] idx = {1, -1, 0, 0};
        int[] idy = {0, 0, 1, -1};
        public int solution(int[][] maze) {
            row = maze.length;
            col = maze[0].length;
            map = maze;

            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(maze[i][j] == 1) {
                        redFirst = new Node(i, j);
                    } else if(maze[i][j] == 2) {
                        blueFirst = new Node(i, j);
                    } else if(maze[i][j] == 3) {
                        redGoal = new Node(i, j);
                    } else if(maze[i][j] == 4) {
                        blueGoal = new Node(i, j);
                    } else {
                        map[i][j] = maze[i][j];
                    }
                }
            }

            boolean[][] redVisited = new boolean[row][col];
            redVisited[redFirst.x][redFirst.y] = true;
            boolean[][] blueVisited = new boolean[row][col];
            blueVisited[blueFirst.x][blueFirst.y] = true;

            dfs(redFirst, blueFirst, 0, redVisited, blueVisited, RED);
            dfs(redFirst, blueFirst, 0, redVisited, blueVisited, BLUE);
            return answer == Integer.MAX_VALUE? 0 : answer / 2;
        }

        public void dfs(Node red, Node blue, int depth, boolean[][] redVisited, boolean[][] blueVisited, int before) {
            if(isEnd(red, blue)) {
                if(depth % 2 != 0) depth++;
                answer = Math.min(answer, depth);
                return;
            }

            if (before == RED) {
                if (red.x == redGoal.x && red.y == redGoal.y) {
                    dfs(red, blue, depth + 1, redVisited, blueVisited, BLUE);
                }
                for (int i = 0; i < 4; i++) {
                    int ndx = red.x + idx[i];
                    int ndy = red.y + idy[i];
                    if (!isInRange(ndx, ndy)) continue;
                    Node nextRed = new Node(ndx, ndy);
                    if (!isValid(nextRed, blue)) continue;
                    if (redVisited[nextRed.x][nextRed.y]) continue;

                    redVisited[nextRed.x][nextRed.y] = true;
                    dfs(nextRed, blue, depth + 1, redVisited, blueVisited, BLUE);
                    redVisited[nextRed.x][nextRed.y] = false;
                }
            }

            if(before == BLUE) {
                if (blue.x == blueGoal.x && blue.y == blueGoal.y) {
                    dfs(red, blue, depth + 1, redVisited, blueVisited, RED);
                }
                for (int i = 0; i < 4; i++) {
                    int ndx = blue.x + idx[i];
                    int ndy = blue.y + idy[i];
                    if (!isInRange(ndx, ndy)) continue;
                    Node nextBlue = new Node(ndx, ndy);
                    if (!isValid(nextBlue, red)) continue;
                    if (blueVisited[nextBlue.x][nextBlue.y]) continue;

                    blueVisited[nextBlue.x][nextBlue.y] = true;
                    dfs(red, nextBlue, depth + 1, redVisited, blueVisited, RED);
                    blueVisited[nextBlue.x][nextBlue.y] = false;
                }
            }
        }

        public boolean isEnd(Node red, Node blue) {
            if(red.x != redGoal.x || red.y != redGoal.y) return false;
            if(blue.x != blueGoal.x || blue.y != blueGoal.y) return false;
            return true;
        }

        public boolean isInRange(int ndx, int ndy) {
            if(ndx < 0 || ndy < 0 || ndx >= row || ndy >= col) return false;
            return true;
        }
        public boolean isValid(Node a, Node b) {
            if(isWall(a)) return false;
            if(isDuplicate(a, b)) return false;
            return true;
        }

        public boolean isDuplicate(Node a, Node b) {
            if(a.x == b.x && a.y == b.y) return true;
            return false;
        }
        public boolean isWall(Node node) {
            if(map[node.x][node.y] == 5) return true;
            return false;
        }
    }
}
