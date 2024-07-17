package week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 위상정렬_줄세우기_2252 {




    static int N;
    static int M;
    static int[] count;
    static List<List<Integer>> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            count[to]++;
            nodes.get(from).add(to);

        }
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
            List<Integer> integers = nodes.get(poll);
            for (Integer integer : integers) {
                count[integer]--;
                if (count[integer] == 0) {
                    queue.offer(integer);
                }
            }
        }

        System.out.println(sb);


    }
}
