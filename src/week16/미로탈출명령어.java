package week16;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출명령어 {

    class Solution {

        int n;
        int m;
        int k;
        int r;
        int c;

        StringBuilder sb = new StringBuilder();
        String answer;



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

        private void dfs(int depth, int x, int y) {
            if(depth == k ) {
                if(x == r && y == c && answer == null) answer = sb.toString();
                return;
            }

            int difX = Math.abs(r - x);
            int difY = Math.abs(c - y);

            if(answer != null) return;
            if(k-depth < difX + difY) return;
            if(((k - depth) - (difX + difY)) % 2 != 0) return;

            for(int i = 0; i< 4; i++) {
                int ndx = x + idx[i];
                int ndy = y + idy[i];
                if(!rangeCheck(ndx, ndy)) continue;
                sb.append(str[i]);
                dfs(depth + 1 , ndx, ndy);
                sb.delete(depth, depth + 1);
            }

            return;

        }

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            this.n = n;
            this.m = m;
            this.k = k;
            this.r = r;
            this.c = c;
            int difX = Math.abs(r - x);
            int difY = Math.abs(c - y);
            if((k - (difX + difY)) % 2 != 0) return "impossible";

            dfs(0, x, y);

            return answer != null? answer : "impossible";
        }

        private boolean rangeCheck(int x, int y) {
            if(x < 1 || y < 1 || x > n || y > m) return false;
            return true;
        }
    }
}
