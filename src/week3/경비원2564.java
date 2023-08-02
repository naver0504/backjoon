package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경비원2564 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int M;
    static Node X;
    static int result = 0;

    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        int r = Integer.parseInt(br.readLine());
        for (int i = 0; i <= r; i++) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node node = getNode(x, y);
            if (i != r ) {
                list.add(node);
            } else {
                X = getNode(x, y);
            }

        }
        int lenght = 2 * N + 2 * M;

        list.forEach(node -> {
                    if (X.y == 0 || X.y == M) {
                        if (X.y == node.y) {
                            result += Math.abs(X.x - node.x);
                        } else if (node.x == 0 || node.x == N) {
                            result += Math.abs(X.x - node.x) + Math.abs(X.y - node.y);
                        } else {
                            int tmp = 0;
                            tmp += M + node.x + X.x;
                            result += Math.min(tmp, lenght - tmp);
                        }
                    } else {
                        if (X.x == node.x) {
                            result += Math.abs(X.y - node.y);
                        } else if (node.y == 0 || node.y == M) {
                            result += Math.abs(X.x - node.x) + Math.abs(X.y - node.y);
                        } else {
                            int tmp = 0;
                            tmp += N + node.y + X.y;
                            result += Math.min(tmp, lenght - tmp);
                        }
                    }

                });

        System.out.println(result);

    }

    private static Node getNode(int x, int y) {
        if (x == 1) {
            return new Node(y, M);
        } else if (x == 2) {
            return new Node(y, 0);
        } else if (x == 3) {
            return new Node(0, M - y);
        } else {
            return new Node(N, M - y);
        }
    }

}
