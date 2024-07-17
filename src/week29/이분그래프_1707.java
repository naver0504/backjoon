package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이분그래프_1707 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int[] map = new int[V + 1];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean flag = false;
            for (int i = 1; i <= V && !flag; i++) {
                if(map[i] != 0) continue;
                List<Integer> integers = graph.get(i);
                if(integers.isEmpty()) continue;
                map[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                for (Integer integer : integers) {
                    queue.offer(integer);
                    map[integer] = -1;
                }

                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();

                    List<Integer> nextNodes = graph.get(poll);
                    for (Integer next : nextNodes) {
                        if (map[next] == 0) {
                            map[next] = map[poll] * -1;
                            queue.offer(next);
                        } else if (map[next] == map[poll]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
            }

            if(flag) System.out.println("NO");
            else System.out.println("YES");
        }

    }
}
