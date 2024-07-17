package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동_16234 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int L;
    static int R;

    static int[][] map;
    static int[][] nextMap;
    static boolean[][] visited;

    static int[] idx = {-1, 1, 0, 0};
    static int[] idy = {0, 0, -1, 1};
    static boolean flag = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int answer = 0;
        while (true) {
            visited = new boolean[N][N];
            nextMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;
                    doBfs(i, j);
                }
            }
            if(!flag) break;
            answer++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map = nextMap;

                }
            }
            flag = false;
        }

        System.out.println(answer);
    }

    private static void doBfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> nodes = new ArrayList<>();
        visited[x][y] = true;
        queue.offer(new Node(x, y));

        int sum = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            sum += map[poll.x][poll.y];
            nodes.add(poll);

            for (int i = 0; i < 4; i++) {
                int ndx = poll.x + idx[i];
                int ndy = poll.y + idy[i];

                if(isOutOfRange(ndx, ndy)) continue;
                if(visited[ndx][ndy]) continue;
                int dif = Math.abs(map[ndx][ndy] - map[poll.x][poll.y]);
                if(dif < L || dif > R) continue;
                visited[ndx][ndy] = true;
                flag = true;
                queue.offer(new Node(ndx, ndy));
            }
        }

        for (Node node : nodes) {
            nextMap[node.x][node.y] = sum / nodes.size();
        }
    }

    private static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= N || ndy >= N);
    }
}
