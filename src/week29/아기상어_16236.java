package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어_16236 {

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int x;
    static int y;
    static int N;
    static int size = 2;
    static int count = 0;
    static int answer = 0;

    static int[][] map;
    static int[] idx = {-1, 0, 1, 0};
    static int[] idy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 9) {
                    x = i;
                    y = j;
                } else{
                    map[i][j] = value;
                }

            }
        }

        while (true) {

            Queue<Node> queue = new PriorityQueue<>((n1, n2) -> {
                if(n1.distance == n2. distance) {
                    if(n1.x == n2.x) {
                        return n1.y - n2.y;
                    } else return n1.x - n2.x;
                } else return n1.distance - n2.distance;
            });
            boolean[][] visited = new boolean[N][N];
            queue.offer(new Node(x, y, 0));
            visited[x][y] = true;

            boolean flag = false;
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                if (map[poll.x][poll.y] != 0 && map[poll.x][poll.y] < size) {
                    count++;
                    x = poll.x;
                    y = poll.y;
                    answer += poll.distance;
                    map[poll.x][poll.y] = 0;
                    flag = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ndx = poll.x + idx[i];
                    int ndy = poll.y + idy[i];
                    if(isOutOfRange(ndx, ndy)) continue;
                    if(visited[ndx][ndy]) continue;
                    if(map[ndx][ndy] > size) continue;

                    visited[ndx][ndy] = true;
                    queue.offer(new Node(ndx, ndy, poll.distance + 1));
                }
            }

            if(!flag) break;

            if (size == count) {
                size++;
                count = 0;
            }
        }


        System.out.println(answer);

    }


    public static boolean isOutOfRange(int ndx, int ndy) {
        return (ndx < 0 || ndy < 0 || ndx >= N || ndy >= N);
    }

}
