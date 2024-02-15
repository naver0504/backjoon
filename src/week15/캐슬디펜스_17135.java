package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 캐슬디펜스_17135 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static int[][] map;
    static int[] archers;
    static int N;
    static int M;
    static int D;

    static int[] idx = {0, -1, 0};
    static int[] idy = {-1, 0, 1};
    static int enemies = 0;



    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        archers = new int[M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) enemies++;

            }
        }

        getResult(0, 0);

        System.out.println(ans);

    }

    private static void getResult(int depth, int startIdx) {

        if (depth == 3) {
            int killed = getKilled();
            ans = Math.max(ans, killed);
            return;
        }

        for (int i = startIdx; i < M; i++) {
            if(archers[i] != 0) continue;
            archers[i] = 1;
            getResult(depth + 1, i + 1);
            archers[i] = 0;
        }

    }

    private static int getKilled() {
        int[][] copied = new int[N][M];

        int result = 0;
        int tmpEnemies = enemies;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copied[i][j] = map[i][j];
            }
        }

        while (tmpEnemies != 0) {

            List<Node> killed = new ArrayList<>(3);

            for (int i = 0; i < M; i++) {
                if(archers[i] == 0) continue;

                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(N, i));
                boolean[][] visited = new boolean[N][M];
                boolean flag = false;
                while (!queue.isEmpty() && !flag) {

                    Node poll = queue.poll();
                    int x = poll.x;
                    int y = poll.y;

                    if ((N - x) + (i - y) >= D) {
                        break;
                    }

                    for (int k = 0; k < 3; k++) {
                        int ndx = x + idx[k];
                        int ndy = y + idy[k];

                        if(!rangeCheck(ndx, ndy)) continue;
                        if(visited[ndx][ndy]) continue;

                        if(copied[ndx][ndy] == 1){
                            killed.add(new Node(ndx, ndy));
                            flag = true;
                            break;
                        }

                        queue.offer(new Node(ndx, ndy));
                    }
                }
            }

            for (Node node : killed) {
                if (copied[node.x][node.y] == 1) {
                    copied[node.x][node.y] = 0;
                    tmpEnemies--;
                    result++;
                }
            }

            for (int i = N - 1; i >= 0; i--) {
                for (int j = M - 1; j >= 0; j--) {
                    if(copied[i][j] == 0) continue;
                    copied[i][j] = 0;
                    if(i + 1 == N) {
                        tmpEnemies--;
                        continue;
                    };
                    copied[i+1][j] = 1;

                }
            }
        }

        return result;

    }

    private static boolean rangeCheck(int ndx, int ndy) {
        if(ndx <0 || ndy < 0 || ndx >= N ||ndy >= M) return false;
        return true;
    }


}
