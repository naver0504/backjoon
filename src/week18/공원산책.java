package week18;

import java.util.Map;

public class 공원산책 {

    class Solution {

        int[][] map;
        int x;
        int y;
        int n;
        int m;

        Map<String, Integer> dirMap = Map.of("N", 0, "S", 1, "W", 2, "E", 3);
        int[] idx = {-1, 1, 0, 0};
        int[] idy = {0, 0, -1, 1};

        public int[] solution(String[] park, String[] routes) {
            n = park.length;
            m = park[0].length();
            map = new int[n][m];

            for(int i = 0; i<park.length; i++) {
                String line = park[i];
                for(int j = 0; j < line.length(); j++) {
                    if(line.charAt(j) == 'X') {
                        continue;
                    } else {
                        if(line.charAt(j) == 'S'){
                            x = i;
                            y = j;
                        }

                        map[i][j] = 1;
                    }
                }
            }

            for(int i = 0; i< routes.length; i++) {
                String line = routes[i];
                String dirStr = line.substring(0, 1);
                int distance = Integer.parseInt(line.substring(2));

                int dir = dirMap.get(dirStr);

                if(!isRangeValid(dir, distance)) continue;

                boolean flag = true;

                int tmpX = x;
                int tmpY = y;

                while(distance > 0) {
                    distance--;
                    tmpX = tmpX + idx[dir];
                    tmpY = tmpY + idy[dir];

                    if(map[tmpX][tmpY] == 0) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    x = tmpX;
                    y = tmpY;
                }

            }
            int[] answer = {x, y};
            return answer;
        }

        private boolean isRangeValid(int dir, int distance) {
            int ndx = x + idx[dir] * distance;
            int ndy = y + idy[dir] * distance;

            if(ndx < 0 || ndy < 0 || ndx >= n || ndy >= m) return false;
            return true;
        }
    }
}
