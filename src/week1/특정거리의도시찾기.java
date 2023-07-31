package week1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기 {

    static class Node {
        int key;

        public Node(int key) {
            this.key = key;
        }
    }

    static int V,E, K, X;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = getInteger(st.nextToken());
        E = getInteger(st.nextToken());
        K = getInteger(st.nextToken());
        X = getInteger(st.nextToken());

        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Node>());
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int left = getInteger(st.nextToken());
            int right = getInteger(st.nextToken());
            graph.get(left).add(new Node(right));
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(X));
        int[] distance = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            distance[i] = -1;
        }
        distance[X] = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            graph.get(temp.key)
                    .forEach(node -> {
                        if (distance[node.key] == -1) {
                            distance[node.key] = distance[temp.key] + 1;
                            queue.offer(new Node(node.key));
                            if (distance[node.key] == K) {
                                result.add(node.key);
                            }
                        }
                    }  );
        }
        result.sort((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();
        result.forEach(integer -> sb.append(integer).append("\n"));
        if (result.isEmpty()) {
            sb.append("-1");
        }
        System.out.print(sb);
    }
    private static int getInteger(String token) {
        return Integer.parseInt(token);
    }
}
