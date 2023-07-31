package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] lx = {1, -1, 0, 0};
    static int[] ly = {0, 0, 1, -1};

    static int[][] arr;
    static int[][] time;
    static int min;
    static int n;
    static int m;
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        arr = new int[n][m];
        time = new int[n][m];
        time[n - 1][m - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int count = 0;
            int x = node.x;
            int y = node.y;
            while (count < 4) {
                int nx = x + lx[count];
                int ny = y + ly[count];
                if (nx  >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(arr[nx][ny] == 0) {
                        if (time[nx][ny] == 0) {
                            time[nx][ny] = time[x][y] + 1;
                            queue.offer(new Node(nx, ny));
                        } else {
                            if (time[nx][ny] > time[x][y] + 1) {
                                time[nx][ny] = time[x][y] + 1;
                                queue.offer(new Node(nx, ny));
                            }
                        }
                    } else if (arr[nx][ny] == 2) {
                        int tmpTime = n - (nx) + m - ny -2 ;
                        min = Math.min(tmpTime + time[x][y] + 1, min);
                    }

                }
                count++;
            }
        }


        int result = Math.min(min, time[n-1][m-1]);
        if (result == 0) {
            System.out.println("Fail");
        } else {
            if(result <= t)
                System.out.println(result);
            else
                System.out.println("Fail");

        }
    }
}
