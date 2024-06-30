package week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ACMCraft {

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.valueOf(st.nextToken());
            int K = Integer.valueOf(st.nextToken());

            int[] d = new int[N];
            List<List<Integer>> graph = new ArrayList<>();

            int[] inDegree = new int[N];
            for (int j = 0; j < N; j++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                d[j] = Integer.valueOf(st.nextToken());
            }


            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(st.nextToken()) - 1;
                int y = Integer.valueOf(st.nextToken()) - 1;
                graph.get(x).add(y);
                inDegree[y]++;
            }

            int goal = Integer.valueOf(br.readLine()) - 1;
            int cost = Integer.MAX_VALUE;

            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
            for (int j = 0; j < N; j++) {
                if (inDegree[j] == 0) {
                    pq.offer(new Node(j, d[j]));
                }
            }

            while (!pq.isEmpty()) {
                Node poll = pq.poll();
                if (poll.idx == goal) {
                    cost = Math.min(cost, poll.cost);
                    break;
                }

                for (int integer : graph.get(poll.idx)) {
                    inDegree[integer]--;
                    if (inDegree[integer] == 0) {
                        pq.offer(new Node(integer, poll.cost + d[integer]));
                    }
                }

            }

            System.out.println(cost);
        }
    }
}
