package week26;

import java.util.ArrayList;
import java.util.List;

public class 거리두기확인하기 {

    class Solution {

        int[] idx = {1, 1, 1, 0, 2, 0};
        int[] idy = {-1, 0, 1, 1, 0, 2};

        public int[] solution(String[][] places) {
            List<Integer> answers = new ArrayList<>();
            for (String[] place : places) {
                boolean flag = false;
                char[][] map = new char[5][5];
                for (int j = 0; j < 5; j++) {
                    String line = place[j];
                    for (int k = 0; k < 5; k++) {
                        char c = line.charAt(k);
                        map[j][k] = c;
                    }
                }


                for (int row = 0; row < 5 && !flag; row++) {
                    for (int col = 0; col < 5 && !flag; col++) {
                        if (map[row][col] != 'P') continue;
                        for (int dir = 0; dir < 6; dir++) {
                            if (dir == 0 || dir == 2) {
                                int ndx = row + idx[dir];
                                int ndy = col + idy[dir];
                                if (!isInRange(ndx, ndy)) continue;
                                if (map[ndx][ndy] != 'P') continue;
                                if (map[row][ndy] != 'X' || map[ndx][col] != 'X') {
                                    flag = true;
                                    break;
                                }
                            } else if (dir == 1 || dir == 3) {
                                int ndx = row + idx[dir];
                                int ndy = col + idy[dir];
                                if (!isInRange(ndx, ndy)) continue;
                                if (map[ndx][ndy] == 'P') {
                                    flag = true;
                                    break;
                                }
                            } else {
                                int ndx = row + idx[dir];
                                int ndy = col + idy[dir];
                                if (!isInRange(ndx, ndy)) continue;
                                if (map[ndx][ndy] != 'P') continue;
                                if (map[(row + ndx) / 2][(col + ndy) / 2] != 'X') {
                                    flag = true;
                                    break;
                                }

                            }

                        }
                    }
                }

                if (flag) answers.add(0);
                else answers.add(1);
            }
            return answers.stream().mapToInt(Integer::intValue).toArray();
        }

        public boolean isInRange(int ndx,int ndy) {
            return ndx >= 0 && ndy >= 0 && ndx < 5 && ndy < 5;
        }
    }
}
