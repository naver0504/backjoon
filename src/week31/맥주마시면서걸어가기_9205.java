package week31;

import java.util.*;

public class 맥주마시면서걸어가기_9205 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            List<Node> stores = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                stores.add(new Node(sc.nextInt(), sc.nextInt()));
            }

            int goalX = sc.nextInt();
            int goalY = sc.nextInt();

            boolean goToStadium = false;
            boolean[] visited = new boolean[n];

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(x, y));
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                if (poll.canGoStadium(goalX, goalY)) {
                    goToStadium = true;
                    break;
                }

                for (int j = 0; j < n; j++) {
                    if(visited[j]) continue;
                    Node store = stores.get(j);
                    int nextX = store.x;
                    int nextY = store.y;
                    if (poll.canGoStadium(nextX, nextY)) {
                        visited[j] = true;
                        queue.offer(new Node(nextX, nextY));
                    }
                }
            }

            sb.append(goToStadium ? "happy" : "sad").append("\n");
        }

        System.out.println(sb);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean canGoStadium(int nextX, int nextY) {
            int difX = Math.abs(x - nextX);
            int difY = Math.abs(y - nextY);
            int dif = difX + difY;

            return 1000 >= dif;
        }
    }
}
