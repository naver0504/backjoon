package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {


    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static List<List<Node>> vectors = new ArrayList<>();
    static int V;
    static int E;
    static int startIdx;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startIdx = Integer.parseInt(br.readLine());
        answer = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            vectors.add(new ArrayList<>());
            answer[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            vectors.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        pq.offer(new Node(startIdx, 0));
        answer[startIdx] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            for (Node node : vectors.get(poll.idx)) {
                if (answer[node.idx] > node.weight + answer[poll.idx]) {
                    answer[node.idx] = node.weight + answer[poll.idx];
                    pq.offer(new Node(node.idx, answer[node.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]);
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
