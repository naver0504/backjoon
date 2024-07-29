package week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2636 {

    static int ROW;
    static int COL;
    static int[][] map;
    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COL; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        int size = 0;
        int time = 0;
        while (true) {

            int curSize = checkSize();
            if (curSize != 0) {
                size = curSize;
                time++;
            } else {
                System.out.println(time);
                System.out.println(size);
                return;
            }

            List<Point> toDelete = new ArrayList<>();
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0));
            boolean[][] visited = new boolean[ROW][COL];
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                Point poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ndx = poll.x + idx[i];
                    int ndy = poll.y + idy[i];

                    if (isOutOfRange(ndx, ndy)) continue;
                    if (visited[ndx][ndy]) continue;
                    if (map[ndx][ndy] == 1) {
                        toDelete.add(new Point(ndx, ndy));
                        continue;
                    }
                    map[ndx][ndy] = -1;
                    queue.offer(new Point(ndx, ndy));
                    visited[ndx][ndy] = true;
                }
            }

            for (Point point : toDelete) {
                map[point.x][point.y] = -1;
            }
        }



    }

    private static int checkSize() {
        int size = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(map[i][j] == 1) size++;
            }
        }

        return size;
    }

    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= ROW || ndy >= COL);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
