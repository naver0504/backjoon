package week16;

import java.util.ArrayList;
import java.util.List;

public class 표병합 {

    class Solution {


        final String MERGE = "MERGE";
        final String UPDATE = "UPDATE";
        final String UNMERGE = "UNMERGE";
        final String PRINT = "PRINT";

        String[] cells = new String[2501];
        int[] unions = new int[2501];

        public int find(int x) {
            if(unions[x] == x) return x;
            else return unions[x] = find(unions[x]);
        }

        public void union(int x, int y) {
            int realX = find(x);
            int realY = find(y);

            if(realX != realY) {
                unions[realY] = realX;
            }
        }

        public String[] solution(String[] commands) {

            for(int i = 1; i<=2500; i++) {
                unions[i] = i;

            }
            List<String> list = new ArrayList<>();

            for(int i = 0; i < commands.length; i++) {
                String[] command = commands[i].split(" ");
                switch(command[0]) {
                    case UPDATE -> {
                        if(command.length == 4) {
                            int r = Integer.parseInt(command[1]);
                            int c = Integer.parseInt(command[2]);
                            String value = command[3];
                            int realPos = find(50 * (r - 1) + c);
                            cells[realPos] = value;
                        } else {
                            String value1 = command[1];
                            String value2 = command[2];
                            for(int j = 1; j<=2500; j++) {
                                int realPos = find(j);
                                if(cells[realPos] != null && cells[realPos].equals(value1)) {
                                    cells[realPos] = value2;
                                }
                            }
                        }
                    }
                    case MERGE -> {
                        int r1 = Integer.parseInt(command[1]);
                        int c1 = Integer.parseInt(command[2]);
                        int r2 = Integer.parseInt(command[3]);
                        int c2 = Integer.parseInt(command[4]);

                        int firstPos = find((r1 - 1)* 50 + c1);
                        int secondPos = find((r2 - 1) * 50 + c2);


                        if(firstPos == secondPos) continue;
                        String value = cells[firstPos] == null ? cells[secondPos] : cells[firstPos];


                        cells[firstPos] = value;
                        cells[secondPos] = null;

                        for(int j = 1; j<=2500; j++) {
                            if(find(j) == secondPos)
                                union(firstPos, j);
                        }
                    }
                    case UNMERGE -> {

                        int r = Integer.parseInt(command[1]);
                        int c = Integer.parseInt(command[2]);

                        int realPos = find(50*(r - 1) + c);
                        String value = cells[realPos];
                        for(int j = 1; j<=2500; j++) {
                            if(find(j) == realPos) {
                                cells[j] = null;
                                unions[j] = j;
                            }

                        }

                        cells[50*(r - 1) + c] = value;

                    }
                    case PRINT -> {
                        int r = Integer.parseInt(command[1]);
                        int c = Integer.parseInt(command[2]);

                        int realPos = find(50 * (r - 1) + c);



                        if(cells[realPos] == null) {
                            list.add("EMPTY");
                        } else {
                            list.add(cells[realPos]);
                        }
                    }



                }



            }


            return list.toArray(new String[0]);

        }
    }
}
