package week30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열4_14002 {

    static int N;
    static int[] values;
    static List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            nodes.add(new Node(1, String.valueOf(values[i])));
        }

        int answerIdx = 0;
        int answerSize = 0;

        for (int i = 1; i < N ; i++) {
            int maxSize = 0;
            int maxIdx = 0;
            for (int j = 0; j < i; j++) {
                if (values[i] > values[j]) {
                    Node node = nodes.get(j);
                    if (maxSize < node.count + 1) {
                        maxSize = node.count + 1;
                        maxIdx = j;
                    }
                }
            }

            if (maxSize != 0) {
                String numStr = nodes.get(maxIdx).numStr;
                Node node = nodes.get(i);
                node.numStr = numStr + " " + values[i];
                node.count = maxSize;
                if(maxSize > answerSize){
                    answerSize = maxSize;
                    answerIdx = i;
                }
            }
        }


        System.out.println(answerSize);
        System.out.println(nodes.get(answerIdx).numStr);

    }

    static class Node {
        int count;
        String numStr;

        public Node(int count, String numStr) {
            this.count = count;
            this.numStr = numStr;
        }
    }

}
