package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {


    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        int time = 0;
        while (true) {
            int size = getSize(map);
            if(size == 0) {
                System.out.println(0);
                return;
            } else if (size == 2) {
                System.out.println(time);
                return;
            }

            time++;
            int[][] nextMap = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    nextMap[i][j] = getNextValue(map, i, j);
                }
            }

            map = nextMap;
        }

    }

    private static int getNextValue(int[][] map, int x, int y) {
        int org = map[x][y];
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int ndx = x + idx[i];
            int ndy = y + idy[i];
            if(isOutOfRange(ndx, ndy)) continue;
            if(map[ndx][ndy] != 0 ) continue;
            count++;
        }

        return Math.max(org - count, 0);
    }

    private static int getSize(int[][] map) {
        boolean[][] visited = new boolean[N][M];
        int sum = 0;
        for (int i = 0; i < N && sum < 2; i++) {
            for (int j = 0; j < M & sum < 2; j++) {
                if(visited[i][j]) continue;
                if(map[i][j] == 0) continue;
                sum++;
                Queue<Node> queue = new LinkedList<>();
                visited[i][j] = true;
                queue.offer(new Node(i, j));
                while (!queue.isEmpty()) {
                    Node poll = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int ndx = poll.x + idx[k];
                        int ndy = poll.y + idy[k];
                        if(isOutOfRange(ndx,ndy)) continue;
                        if(map[ndx][ndy] == 0) continue;
                        if(visited[ndx][ndy]) continue;

                        visited[ndx][ndy] = true;
                        queue.offer(new Node(ndx, ndy));
                    }
                }
            }
        }

        return sum ;
    }

    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= N || ndy >= M);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
