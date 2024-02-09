package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class 소문난칠공주_1941 {

    static final char SOM = 'S';

    static int idx[] = {0, 0, 1, -1};
    static int idy[] = {1, -1, 0, 0};


    static char[][] map;
    static boolean[] visit;

    static int ans = 0;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        visit = new boolean[25];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }



        dfs(0, 0, 0);

        System.out.println(ans);
    }

    private static void dfs(int startIdx, int length, int sCount) {

        if (length - sCount >= 4) {
            return;
        }

        if (length == 7) {
            if (sCount >= 4) {
                if (isValid()) {
                    ans++;
                }
            }
            return;
        }

        for (int i = startIdx; i < 25; i++) {

            if(visit[i]) continue;

            visit[i] = true;

            if(map[i / 5][i % 5] == SOM){ dfs(i + 1, length + 1, sCount + 1);}

            else{ dfs(i + 1 ,length + 1, sCount);}

            visit[i] = false;

        }
    }

    private static boolean isValid() {

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < 25; i++) {
            if (visit[i]) {
                startX = i /5;
                startY = i % 5;
                break;
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[5][5];
        int seven = 1;

        queue.add(new Node(startX, startY));

        vis[startX][startY] = true;



        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;


            for (int i = 0; i < 4; i++) {

                int ndx = x + idx[i];
                int ndy = y + idy[i];

                if (ndx < 0 || ndy < 0 || ndx >= 5 || ndy >= 5) continue;
                if (vis[ndx][ndy]) continue;
                if (!visit[ndx * 5 + ndy]) continue;

                seven++;
                queue.offer(new Node(ndx, ndy));
                vis[x][y] = true;
            }
        }

        return seven == 7;

    }


}
