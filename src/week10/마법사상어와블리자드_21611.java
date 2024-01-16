package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 마법사상어와블리자드_21611 {

    static class Ball {
        int x;
        int y;
        int value;

        public Ball(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static int N;
    static int[][] map;
    static int result = 0;

    static int[] idx = {0, 1, 0, -1};
    static int[] idy = {-1, 0, 1, 0};



    static List<Ball> balls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setUp();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            blizzard(d, s);
            while (explosion());
            makeBall();
            reSetUp();

        }


        System.out.println(result);




    }

    private static void makeBall() {
        List<Ball> tmp = new ArrayList<>();
        int count = 1;
        int value = 0;
        int size = balls.size();
        for (int i = 1; i < size; i++) {
            Ball now = balls.get(i);
            value = now.value;
            Ball pre = balls.get(i - 1);
            if (pre.value == now.value) {
                count++;
            } else {
                tmp.add(new Ball(0, 0, count));
                tmp.add(new Ball(0, 0, pre.value));
                count = 1;
            }
        }
        tmp.add(new Ball(0, 0, count));
        tmp.add(new Ball(0, 0, value));
        balls = tmp;

    }

    private static boolean explosion() {
        boolean flag = false;
        Deque<Ball> tmpList = new LinkedList<>();
        int count = 1;
        int size = balls.size();
        tmpList.add(balls.get(0));
        for (int i = 1; i < size; i++) {
            Ball now = balls.get(i);
            Ball pre = balls.get(i - 1);
            if (pre.value == now.value) {
                count++;
                tmpList.add(now);
            } else {
                if (count >= 4) {
                    result += count * pre.value;
                    while (count > 0) {
                        tmpList.pollLast();
                        count--;
                    }
                    flag = true;
                }

                count = 1;
                tmpList.add(now);
            }
        }
        balls = tmpList.stream().collect(Collectors.toList());
        return flag;
    }

    private static void setUp() {
        int x = N / 2;
        int y = N / 2;
        int dir = 0;
        int count = 0;
        int size = 1;
        while (true) {
            for(int i = 0; i < size; i++) {
                x = x + idx[dir];
                y = y + idy[dir];
                if (x == 0 && y == 0) break;
                if(map[x][y] == 0) break;
                balls.add(new Ball(x, y, map[x][y]));
            }

            if (x == 0 && y == 0) break;
            if(map[x][y] == 0) break;

            dir = (dir + 1) % 4;

            count++;
            if (count == 2) {
                count = 0;
                size++;
            }
        }

    }

    private static void reSetUp() {
        List<Ball> tmp = new ArrayList<>();
        int x = N / 2;
        int y = N / 2;
        int dir = 0;
        int count = 0;
        int size = 1;
        int totalCount = 0;
        while (totalCount < balls.size()) {
            for(int i = 0; i < size; i++) {
                Ball ball = balls.get(totalCount++);
                x = x + idx[dir];
                y = y + idy[dir];
                if (x == 0 && y == 0) break;
                tmp.add(new Ball(x, y, ball.value));
                if (totalCount == balls.size()) {
                    balls = tmp;
                    return;
                }
            }
            dir = (dir + 1) % 4;
            count++;
            if (count == 2) {
                count = 0;
                size++;
            }
        }
    }

    private static void blizzard(int d, int s) {
        int x = N / 2;
        int y = N / 2;

        int[] bliXDir = {-1, 1, 0, 0};
        int[] bliYDir = {0, 0, -1, 1};

        int[][] tmpDelList = new int[s+1][2];

        for (int i = 0; i < s; i++) {
            x += bliXDir[d - 1];
            y += bliYDir[d - 1];
            tmpDelList[i][0] = x;
            tmpDelList[i][1] = y;
        }
        int count = 0;
        List<Ball> tmpList = new ArrayList<>();
        for (Ball ball : balls) {
            if (ball.x == tmpDelList[count][0] && ball.y == tmpDelList[count][1]) {
                count++;
                continue;
            }
            tmpList.add(ball);
        }

        balls = tmpList;

    }
}
