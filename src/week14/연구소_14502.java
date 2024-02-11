package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소_14502 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;

    static int[][] map;
    static int[] map2;
    static List<Node> list;

    static int idx[] = {0, 0, 1, -1};
    static int idy[] = {1, -1, 0, 0};

    static int ans = Integer.MIN_VALUE;
    static int walls = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        map2 = new int[N * M];
        list = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map2[i * M + j] = map[i][j];
                if(map[i][j] == 2){
                    list.add(new Node(i, j));
                }

                else if (map[i][j] == 1) {
                    walls++;

                }
            }
        }

        createWall(0, 0);
        System.out.println(ans);


    }

    private static void createWall(int walls, int startIdx) {
        if (walls == 3) {
            int safeArea = getSafeArea();
            ans = Math.max(ans, safeArea);
            return;
        }

        for (int i = startIdx; i < N * M; i++) {
            if(map2[i] != 0) continue;

            map2[i] = 1;
            map[i / M][i % M] = 1;
            createWall(walls + 1, i + 1);
            map[i / M][i % M] = 0;
            map2[i] = 0;

        }

    }

    private static int getSafeArea() {

        Queue<Node> queue = new LinkedList<>();
        int virus = list.size();

        boolean[][] visited = new boolean[N][M];

        for (Node node : list) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {

                int ndx = x + idx[i];
                int ndy = y + idy[i];

                if(!rangeCheck(ndx, ndy)) continue;
                if(map[ndx][ndy] != 0) continue;
                if(visited[ndx][ndy]) continue;

                visited[ndx][ndy] = true;
                queue.offer(new Node(ndx, ndy));
                virus++;
            }
        }

        return getSafeAreaResult(virus);
    }

    private static int getSafeAreaResult(int virus) {

        return N * M - (walls + 3) - virus;
    }

    static boolean rangeCheck(int x, int y) {
        if(x <0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }


}
