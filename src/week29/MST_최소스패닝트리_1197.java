package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MST_최소스패닝트리_1197 {

    static class Node {
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    static int V;
    static int E;
    static int[] parents;
    static Queue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.value - n2.value);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.add(new Node(from, to, value));
        }

        int weight = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x = find(poll.from);
            int y = find(poll.to);
            if(x == y) continue;
            weight += poll.value;
            union(x, y);
        }

        System.out.println(weight);

    }


    public static int find(int x) {
        if(parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }
}
