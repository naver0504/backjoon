package week32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 선긋기_2170 {

    static List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            nodes.add(new Node(left, right));
        }

        nodes.sort((n1, n2) -> {
            if (n1.left != n2.left) {
                return n1.left - n2.left;
            } else {
                return n2.right - n1.right;
            }
        });
        int answer = 0;
        int left = nodes.get(0).left;
        int right = nodes.get(0).right;
        answer += right - left;

        for (int i = 1; i < nodes.size(); i++) {
            Node node = nodes.get(i);

            if (node.left > right) {
                left = node.left;
                right = node.right;
                answer += right - left;
            } else {
                if(node.right > right) {
                    answer += node.right - right;
                    right = node.right;
                }
            }
        }

        System.out.println(answer);

    }


    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
