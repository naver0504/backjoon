package week13;

import java.util.*;

class 도넛과막대그래프 {

    static class Node {

        int idx;
        int in;
        int out;

        Node (int idx) {
            this.idx = idx;
        }
    }
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int max = 0;


        Map<Integer, Node> nodeMap = new HashMap<>();

        for(int i = 0; i<edges.length; i++){
            int out = edges[i][0];
            int in = edges[i][1];

            max = Math.max(max, Math.max(in, out));

            if(!nodeMap.containsKey(in)){

                nodeMap.put(in, new Node(in));
            }

            if(!nodeMap.containsKey(out)){

                nodeMap.put(out, new Node(out));
            }

            Node outNode = nodeMap.get(out);
            Node inNode = nodeMap.get(in);

            outNode.out++;
            inNode.in++;

            nodeMap.put(out, outNode);
            nodeMap.put(in, inNode);

        }

        int ans0 = 0;
        int ans2 = 0;
        int ans3 = 0;

        for(int i = 1; i<=max; i++){
            Node node = nodeMap.get(i);
            if(node.out == 0) {
                ans2++;
            }else if(node.out >= 2) {
                if(node.in == 0) {
                    ans0 = i;
                } else {
                    ans3++;
                }
            }

        }




        answer[0] = ans0;
        answer[1] = nodeMap.get(ans0).out - ans2 - ans3;
        answer[2] = ans2;
        answer[3] = ans3;


        return answer;
    }
}