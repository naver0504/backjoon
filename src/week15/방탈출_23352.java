package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 방탈출_23352 {

    static class Node{
        int x;
        int y;
        int length;

        public Node(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    static int[] idx = {-1, 0, 1, 0};
    static int[] idy = {0, 1, 0, -1};

    static int[][] map;

    static int N;
    static int M;

    static int ans = 0;
    static int Length = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) continue;
                getResult(i, j);
            }
        }



        System.out.println(ans);

    }


    private static int getResult(int startX, int startY) {



        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Node(startX, startY, 1));
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;
            int length = poll.length;

            if (length >= Length) {
                if (length == Length) {
                    ans = Math.max(ans, map[startX][startY] + map[x][y]);
                } else {
                    ans = map[startX][startY] + map[x][y];
                    Length = length;
                }
            }

            for (int i = 0; i < 4; i++) {
                int ndx = x + idx[i];
                int ndy = y + idy[i];
                if(!rangeCheck(ndx, ndy)) continue;
                if(visited[ndx][ndy]) continue;
                if(map[ndx][ndy] == 0) continue;
                visited[ndx][ndy] = true;
                queue.add(new Node(ndx, ndy, length + 1));
            }

        }

        return 0;

    }

    private static boolean rangeCheck(int ndx, int ndy) {
        if(ndx < 0 || ndy < 0 || ndx >= N || ndy >= M) return false;
        return true;
    }
}
