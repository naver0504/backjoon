package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주난의난_14497 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int result = 0;
    static int startX, startY;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0 ,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken())-1;
        startY = Integer.parseInt(st.nextToken())-1;
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j<M; j++){
                if(line.charAt(j) == '#'){
                    map[i][j] = -1;}
                else{
                    if(line.charAt(j) == '*'){
                        map[i][j] = 0;
                        visited[i][j] = 1;
                        continue;
                    }
                    map[i][j] = Integer.valueOf(line.charAt(j) - '0');
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        List<Point> nextList = new LinkedList<>();
        queue.add(new Point(startX, startY));
        while(true) {
            result++;
            while (!queue.isEmpty()) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                int count = 0;
                while(count < 4) {
                    int nx = x + dx[count];
                    int ny = y + dy[count];
                    count++;
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(map[nx][ny] == -1) {
                        System.out.println(result);
                        return;
                    } else if (map[nx][ny] == 1) {
                        if (visited[nx][ny] == 0) {
                            nextList.add(new Point(nx, ny));
                            visited[nx][ny] = 1;
                        }
                    } else {
                        if(visited[nx][ny] == 0) {
                            queue.add(new Point(nx, ny));
                            visited[nx][ny] = 1;
                        }
                    }

                }
            }
            for (Point point : nextList) {
                queue.add(point);
                map[point.x][point.y] = 0;
            }
            nextList.clear();
        }
    }
}


