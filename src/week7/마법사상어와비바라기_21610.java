package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 마법사상어와비바라기_21610 {

     static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;

        }
    }

    static int[][] map;
    static int[][] isCloud;
    static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new int[N][N];
        isCloud = new int[N][N];

        isCloud[N-1][0] = 1;
        isCloud[N-1][1] = 1;
        isCloud[N-2][0] = 1;
        isCloud[N-2][1] = 1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.valueOf(st.nextToken());
            int moveCount = Integer.valueOf(st.nextToken());
            moveCloud(direction - 1, moveCount);
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    result += map[i][j];
            }
        }
        System.out.println(result);

    }

    public static void moveCloud(int direction, int moveCount) {
        moveCount %= N;
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isCloud[i][j] == 1) {
                    int ndx = i + moveCount * dx[direction];
                    int ndy = j + moveCount * dy[direction];

                    if (ndx < 0) {
                        ndx += N;
                    }

                    if (ndx >= N) {
                        ndx -= N;
                    }

                    if (ndy < 0) {
                        ndy += N;
                    }

                    if (ndy >= N) {
                        ndy -= N;
                    }

                    isCloud[i][j] = 0;
                    list.add(new Node(ndx, ndy));
                }
            }
        }

        for (Node node : list) {
            int x = node.i;
            int y = node.j;
            map[x][y]++;
            isCloud[x][y] = 1;
        }

        for (Node node : list) {
            int x = node.i;
            int y = node.j;
            for (int i = 1; i < dx.length; i += 2) {
                int ndx = x + dx[i];
                int ndy = y + dy[i];

                //범위 안에 있는 지 확인
                if (ndx >= 0 && ndx < N && ndy >= 0 && ndy < N) {
                    if (map[ndx][ndy] >= 1) {
                        map[x][y]++;
                    }
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isCloud[i][j] == 1) {
                    isCloud[i][j] = 0;
                } else {
                    if (map[i][j] >= 2) {
                        map[i][j] -= 2;
                        isCloud[i][j] = 1;
                    }
                }
            }
        }



    }
}
