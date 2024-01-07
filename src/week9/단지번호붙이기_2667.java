package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 단지번호붙이기_2667 {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int[][] map;
    static int[][] visited;
    static List<Integer> result = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }


        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && visited[i][j] == 0)
                    bfs(i, j);
            }
        }

        System.out.println(result.size());
        result.stream().sorted().forEach(System.out::println);

    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        visited[i][j] = 1;

        int count = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = pair.x + dx[k];
                int ny = pair.y + dy[k];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(map[nx][ny] == 0 || visited[nx][ny] == 1) continue;

                queue.add(new Pair(nx, ny));
                visited[nx][ny] = 1;
                count++;
            }
        }

        result.add(count);
    }
}
