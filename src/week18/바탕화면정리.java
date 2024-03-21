package week18;

public class 바탕화면정리 {

    class Solution {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int n;
        int m;
        public int[] solution(String[] wallpaper) {
            n = wallpaper.length;
            m = wallpaper[0].length();

            for(int i = 0; i<n; i++) {
                String wall = wallpaper[i];

                for(int j = 0; j<m; j++) {
                    if(wall.charAt(j) == '#') {
                        minX = Math.min(minX, i);
                        minY = Math.min(minY, j);

                        maxX = Math.max(maxX, i);
                        maxY = Math.max(maxY, j);

                    }
                }
            }
            int[] answer = {minX, minY,maxX + 1, maxY + 1};
            return answer;
        }
    }
}
