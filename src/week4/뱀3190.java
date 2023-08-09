package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀3190 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    static int N;
    static int K;
    static int L;
    static int[] idx = {0, 1, 0, -1};
    static int[] idy = {1, 0, -1, 0};
    static Deque<Node> snake = new LinkedList<>();
    static int[][] apple;
    static HashMap<Integer, Character> turn;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        snake.add(new Node(1, 1));
        apple = new int[N+1][N+1];
        for(int i = 0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            apple[x][y] = 1;
        }
        L= Integer.parseInt(br.readLine());
        turn = new HashMap<>(L);
        for(int i = 0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            turn.put(time, dir);
        }



        boolean stop = false;
        int dir = 0;
        int x =1;
        int y= 1;
        while (!stop) {
            int nx = x + idx[dir];
            int ny = y + idy[dir];
            if(nx < 1 || ny < 1 || nx > N || ny > N) {
                stop = true;
                time++;
                break;
            }
            Optional<Node> optionalSnake = snake.stream()
                    .filter(snakeNode -> snakeNode.x == nx && snakeNode.y == ny)
                    .findFirst();
            if (optionalSnake.isPresent()) {
                stop = true;
                time++;
                break;
            }


            Node node = new Node(nx, ny);

            if(apple[nx][ny] == 1) {
                apple[nx][ny] = 0;
                snake.offerLast(node);
            } else {
                snake.offerLast(node);
                snake.pollFirst();
            }

            time++;


            if(turn.containsKey(time)) {
                char way = turn.get(time);
                if (way == 'L') {
                    dir -= 1;
                    if (dir < 0) {
                        dir = 3;
                    }
                } else if (way == 'D') {
                    dir += 1;
                    if (dir > 3) {
                        dir = 0;
                    }
                }
                turn.remove(time);
            }

            x = nx;
            y = ny;
        }

        System.out.print(time);

    }
}
