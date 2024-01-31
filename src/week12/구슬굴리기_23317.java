package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 구슬굴리기_23317 {


    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<long[]> triangle;
    static long[] sum;
    static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        triangle = new ArrayList<>(n);
        sum = new long[n + 1];

        for (int line = 1; line <= n ; line++)
        {
            long  c = 1;
            long[] array = new long[line];
            for (int i = 1; i <= line; i++)
            {
                array[i-1] = c;
                sum[line - 1] += c;
                c = c * (line - i) / i;
            }
            triangle.add(array);
        }




        int m = Integer.parseInt(br.readLine());
        nodes = new ArrayList<>(m);
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.add(new Node(x, y));
        }
        nodes.sort(((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            } else {
                return o1.x - o2.x;
            }
        }));
        int previousX = 0;
        int previousY = 0;
        long result = 1;
        for (Node node : nodes) {
            int x = node.x;
            int y = node.y;
            int currentX = x - previousX;
            int currentY = y - previousY;

            if (currentY < 0 || currentX < currentY) {
                System.out.println(0);
                return;
            }

            result *= triangle.get(currentX)[currentY];

            previousX = x;
            previousY = y;
        }

        result *= sum[n - 1 - previousX];

        System.out.println(result);

    }




}
