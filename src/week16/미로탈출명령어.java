package week16;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출명령어 {

    class Solution {

        int n;
        int m;

        int[] idx = {1, 0, 0, -1};
        int[] idy = {0, -1, 1, 0};

        String[] str = {"d", "l", "r", "u"};


        static class Node {

            int x;
            int y;
            String route;
            Node(int x, int y, String route) {
                this.x = x;
                this.y = y;
                this.route = route;
            }
        }

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            this.n = n;
            this.m = m;


            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(x, y, ""));

            if(Math.abs(r- x) + Math.abs(c - y) > k) return "impossible";
            if((k - Math.abs(r- x) + Math.abs(c - y)) % 2 != 0 ) return "impossible";

            while(!queue.isEmpty()) {
                Node poll = queue.poll();
                String route = poll.route;
                int length = route.length();

                int difX = Math.abs(r- poll.x);
                int difY = Math.abs(c- poll.y);
                if(k - length < difX + difY) continue;
                if(((k - length) - (difX + difY)) % 2 != 0) continue;

                for(int i = 0; i< 4; i++) {
                    int ndx = poll.x + idx[i];
                    int ndy = poll.y + idy[i];



                    if(!rangeCheck(ndx, ndy)) continue;




                    if(length + 1 == k && ndx == r && ndy == c) {
                        return route + str[i];
                    } else {
                        queue.offer(new Node(ndx, ndy, route + str[i]));
                    }

                }
            }


            return "impossible";
        }

        private boolean rangeCheck(int x, int y) {
            if(x < 1 || y < 1 || x > n || y > m) return false;
            return true;
        }
    }
}
