package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소트게임_1327 {

    static class Node {
        String s;
        int depth;

        public Node(String s, int depth) {
            this.s = s;
            this.depth = depth;
        }
    }



    static int min = Integer.MAX_VALUE;
    static int N;
    static int K;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        String line = br.readLine().replaceAll(" ", "");

        set = new HashSet<>();
        dfs(line);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void dfs(String s) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(s, 0));
        set.add(s);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (isAsc(poll.s)) {
                min = Math.min(poll.depth, min);
                break;
            }

            for (int i = 0; i <= N - K ; i++) {
                String reverse = reverseArray(poll.s, i);
                if(set.contains(reverse)) continue;
                set.add(reverse);
                queue.add(new Node(reverse, poll.depth + 1));
            }

        }
    }

    private static String reverseArray(String s, int idx) {
        String first = s.substring(0, idx);
        String second = s.substring(idx, idx + K);
        String third = s.substring(idx + K);
        StringBuilder sb = new StringBuilder(second);
        String reverse = sb.reverse().toString();

        return first + reverse + third;
    }

    private static boolean isAsc(String s) {
        int idx = 0;
        while (idx + 1 < N) {
            if (s.charAt(idx) > s.charAt(idx+1)) {
                return false;
            }
            idx++;
        }

        return true;
    }
}
