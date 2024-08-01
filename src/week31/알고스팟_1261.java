package week31;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 알고스팟_1261 {

    static int ROW;
    static int COL;

    static int[][] map;
    static boolean[][] visited;
    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        COL = sc.nextInt();
        ROW = sc.nextInt();

        map = new int[ROW][COL];
        visited = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            String line = sc.next();
            for (int j = 0; j < COL; j++) {
                int value = line.charAt(j) - '0';
                map[i][j] = value;
            }
        }

        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.breakWalls - n2.breakWalls);
        visited[0][0] = true;

        queue.offer(new Node(0, 0, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.x == ROW - 1 && poll.y == COL - 1) {
                System.out.println(poll.breakWalls);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ndx = poll.x + idx[i];
                int ndy = poll.y + idy[i];

                if(isOutOfRange(ndx, ndy)) continue;
                if(visited[ndx][ndy]) continue;
                visited[ndx][ndy] = true;
                if(map[ndx][ndy] == 0) queue.offer(new Node(ndx, ndy, poll.breakWalls));
                else queue.offer(new Node(ndx, ndy, poll.breakWalls + 1));
            }
        }

    }


    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= ROW || ndy >= COL);
    }

    private static class Node {
        int x;
        int y;
        int breakWalls;

        public Node(int x, int y, int breakWalls) {
            this.x = x;
            this.y = y;
            this.breakWalls = breakWalls;
        }
    }
}
