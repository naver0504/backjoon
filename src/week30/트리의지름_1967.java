package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의지름_1967 {

    static class Edge {
        int idx;
        int weight;

        public Edge(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static int N;
    static List<List<Edge>> graph = new ArrayList<>();
    static int answer  = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, weight));
        }

        dfs(1);

        System.out.println(answer);
    }

    private static int dfs(int root) {
        List<Edge> edges = graph.get(root);

        if (edges.isEmpty()) {
            return 0;
        }

        int[] values = new int[edges.size()];

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            values[i] = dfs(edge.idx) + edge.weight;
        }
        if (edges.size() == 1) {
            answer = Math.max(answer, values[0]);
            return values[0];
        } else {
            Arrays.sort(values);
            answer = Math.max(answer, values[edges.size() - 1] + values[edges.size() - 2]);
            return values[edges.size() - 1];
        }
    }
}
