package week19;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 미로탈출 {
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

        int[] idx = {-1, 1, 0, 0};
        int[] idy = {0, 0, -1, 1};

        static char START = 'S';
        static char LEVER = 'L';
        static char EXIT = 'E';
        static char WALL = 'X';



        Map<Character, Integer> map = Map.of(
                WALL, 0,
                START, 1,
                LEVER, 2,
                EXIT, 3,
                'O' , 4
        );

        int[][] arr;
        int row;
        int col;

        int startX;
        int startY;
        int lastX;
        int lastY;

        public int solution(String[] maps) {
            row = maps.length;
            col = maps[0].length();

            arr = new int[row][col];
            int answer1 = 0;
            for(int i = 0; i < row; i++) {
                String line = maps[i];
                for(int j = 0; j <col; j++) {
                    arr[i][j] = map.get(line.charAt(j));
                    if(arr[i][j] == 1) {
                        startX = i;
                        startY = j;
                    } else if(arr[i][j] == 2) {
                        lastX = i;
                        lastY = j;
                    }

                }
            }

            Queue<Node> queue1 = new LinkedList<>();
            boolean[][] visited1 = new boolean[row][col];
            visited1[startX][startY] = true;
            queue1.add(new Node(startX, startY, 0));


            while(!queue1.isEmpty()) {
                Node node = queue1.poll();
                if(arr[node.x][node.y] == 2) {
                    startX = node.x;
                    startY = node.y;
                    answer1 = node.count;
                    break;
                }
                for(int i = 0; i < 4; i++) {
                    int ndx = node.x + idx[i];
                    int ndy = node.y + idy[i];

                    if(!isValid(ndx, ndy)) continue;
                    if(arr[ndx][ndy] == 0) continue;
                    if(visited1[ndx][ndy]) continue;
                    visited1[ndx][ndy] = true;
                    queue1.add(new Node(ndx, ndy, node.count + 1));

                }
            }

            Queue<Node> queue2 = new LinkedList<>();
            boolean[][] visited2 = new boolean[row][col];
            visited2[startX][startY] = true;
            int answer2 = 0;

            queue2.add(new Node(startX, startY, 0));


            while(!queue2.isEmpty()) {
                Node node = queue2.poll();
                if(arr[node.x][node.y] == 3) {
                    answer2 = node.count;
                    break;
                }

                for(int i = 0; i < 4; i++) {
                    int ndx = node.x + idx[i];
                    int ndy = node.y + idy[i];

                    if(!isValid(ndx, ndy)) continue;
                    if(arr[ndx][ndy] == 0) continue;
                    if(visited2[ndx][ndy]) continue;
                    visited2[ndx][ndy] = true;
                    queue2.add(new Node(ndx, ndy, node.count + 1));
                }
            }

            return answer1 == 0 || answer2 == 0 ? -1 : answer1 + answer2;
        }

        boolean isValid(int x, int y) {
            if(x < 0 || y < 0 || x >= row || y >= col) return false;
            return true;
        }
    }
}
