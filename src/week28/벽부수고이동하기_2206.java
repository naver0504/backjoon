package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {

    static class Node {
        int x;
        int y;
        int cost;
        boolean breakWall;

        public Node(int x, int y, int cost, boolean breakWall) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.breakWall = breakWall;
        }
    }

    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};

    static int[][] map;
    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        queue.offer(new Node(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int cost = poll.cost;

            if (isEndOfMap(x, y)) {
                answer = Math.min(answer, cost);
            }

            for (int i = 0; i < 4; i++) {
                int ndx = x + idx[i];
                int ndy = y + idy[i];
                if(isOutOfRange(ndx, ndy)) continue;
                if (map[ndx][ndy] == 0) {
                    if (poll.breakWall && !visited[ndx][ndy][1]) {
                        visited[ndx][ndy][1] = true;
                        queue.offer(new Node(ndx, ndy, cost + 1, true));
                    }

                    if (!poll.breakWall && !visited[ndx][ndy][0]) {
                        visited[ndx][ndy][0] = true;
                        queue.offer(new Node(ndx, ndy, cost + 1, false));
                    }
                } else {
                    if (!poll.breakWall) {
                        visited[ndx][ndy][1] = true;
                        queue.offer(new Node(ndx, ndy, cost + 1, true));
                    }

                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }



    public static boolean isEndOfMap(int x, int y) {
        return x == N - 1 && y == M - 1;
    }
    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= N || ndy >= M);
    }

}
