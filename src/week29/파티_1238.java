package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티_1238 {

    static class Node {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    static int N;
    static int M;
    static int X;
    static List<List<Node>> graph;
    static List<List<Node>> reverseGraph;
    static int[] map;
    static int[] reverseMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N + 1);
        reverseGraph = new ArrayList<>(N + 1);
        map = new int[N + 1];
        reverseMap = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            map[i] = Integer.MAX_VALUE;
            reverseMap[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, time));
            reverseGraph.get(to).add(new Node(from, time));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.time - n2.time);
        List<Node> nodes = graph.get(X);
        for (Node node : nodes) {
            queue.offer(node);
            map[node.idx] = node.time;
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            List<Node> nextNodes = graph.get(poll.idx);
            for (Node nextNode : nextNodes) {
                if (map[nextNode.idx] > nextNode.time + map[poll.idx]) {
                    map[nextNode.idx] = nextNode.time + map[poll.idx];
                    queue.offer(new Node(nextNode.idx, map[nextNode.idx]));
                }
            }
        }

        nodes = reverseGraph.get(X);
        for (Node node : nodes) {
            queue.offer(node);
            reverseMap[node.idx] = node.time;
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            List<Node> nextNodes = reverseGraph.get(poll.idx);
            for (Node nextNode : nextNodes) {
                if (reverseMap[nextNode.idx] > nextNode.time + reverseMap[poll.idx]) {
                    reverseMap[nextNode.idx] = nextNode.time + reverseMap[poll.idx];
                    queue.offer(new Node(nextNode.idx, reverseMap[nextNode.idx]));
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {

            max = Math.max(map[i] + reverseMap[i], max);
        }

        System.out.println(max);

    }
}
