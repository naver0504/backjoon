package week19;

import java.util.Map;

public class 혼자서하는틱택토 {

    class Solution {

        int[][] arr = new int[3][3];
        Map<Character, Integer> map = Map.of(
                '.' , 0,
                'O' , 1,
                'X' , 2
        );

        int IMPOSSIBLE = 0;
        int POSSIBLE = 1;

        public int solution(String[] board) {

            int o = 0;
            int x = 0;
            for(int i = 0; i < 3; i++) {
                String line = board[i];
                for(int j = 0; j < 3; j++) {
                    char c = line.charAt(j);
                    int value = map.get(c);
                    arr[i][j] = value;
                    if(value == 1) {
                        o++;
                        continue;
                    }

                    if(value == 2) {
                        x++;
                    }
                }
            }

            if(x > o) return IMPOSSIBLE;
            if(x < o && x + 1 != o) return IMPOSSIBLE;

            boolean oFinish = isFinished(1);
            boolean xFinish = isFinished(2);

            if(oFinish) {
                if(o == x) {
                    return IMPOSSIBLE;
                }
            }

            if(xFinish) {
                if(o > x) {
                    return IMPOSSIBLE;
                }
            }



            return POSSIBLE;
        }

        public boolean isFinished(int value) {
            if(arr[0][0] == value && arr[0][1] == value && arr[0][2] == value) return true;
            if(arr[1][0] == value && arr[1][1] == value && arr[1][2] == value) return true;
            if(arr[2][0] == value && arr[2][1] == value && arr[2][2] == value) return true;

            if(arr[0][0] == value && arr[1][0] == value && arr[2][0] == value) return true;
            if(arr[0][1] == value && arr[1][1] == value && arr[2][1] == value) return true;
            if(arr[0][2] == value && arr[1][2] == value && arr[2][2] == value) return true;


            if(arr[0][0] == value && arr[1][1] == value && arr[2][2] == value) return true;
            if(arr[0][2] == value && arr[1][1] == value && arr[2][0] == value) return true;

            return false;
        }
    }
}
