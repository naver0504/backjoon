package week32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 불_4179 {

    static int R;
    static int C;
    static int[][] map;
    static int[][] fireMap;
    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};

    static Queue<Node> fires = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        fireMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fireMap[i][j] = Integer.MAX_VALUE;

            }
        }

        int x = 0, y = 0;
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = line.charAt(j);
                if (c == '#') {
                    map[i][j] = -1;
                } else if (c == 'J') {
                    x = i;
                    y = j;
                } else if (c == 'F') {
                    fireMap[i][j] = 0;
                    visited[i][j] = true;
                    fires.offer(new Node(i, j, 0));
                }
            }
        }


        while (!fires.isEmpty()) {
            Node fire = fires.poll();
            int fireX = fire.x;
            int fireY = fire.y;

            for (int i = 0; i < 4; i++) {
                int ndx = fireX + idx[i];
                int ndy = fireY + idy[i];
                if (isOutOfRange(ndx, ndy)) continue;
                if(visited[ndx][ndy]) continue;
                if (map[ndx][ndy] == -1) continue;

                visited[ndx][ndy] = true;
                fireMap[ndx][ndy] = fire.time + 1;
                fires.offer(new Node(ndx, ndy, fire.time + 1));
            }
        }

        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[R][C];
        visited[x][y] = true;
        queue.offer(new Node(x, y, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.isEnd()) {
                System.out.println(poll.time + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ndx = poll.x + idx[i];
                int ndy = poll.y + idy[i];

                if(isOutOfRange(ndx, ndy)) continue;
                if(map[ndx][ndy] == -1) continue;
                if(visited[ndx][ndy]) continue;
                if(poll.time + 1>= fireMap[ndx][ndy]) continue;

                visited[ndx][ndy] = true;
                queue.offer(new Node(ndx, ndy, poll.time + 1));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= R || ndy >= C);
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public boolean isEnd() {
            return (x == 0) || (x == R - 1) || (y == 0) || (y == C - 1);
        }
    }

}

