package week27;

import java.util.Scanner;

public class 소용돌이예쁘게출력하기_1022 {

    static int[][] map;
    static int[] idx = {0, -1, 0, 1};
    static int[] idy = {1, 0, -1, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        map = new int[r2 - r1 + 1][c2 - c1 + 1];

        int x = 0; int y = 0;
        int count = 1; int length = 1;int dir = 0;

        int max = 0;
        if (r1 <= x && x <= r2 && c1 <= y && y <= c2 ) {
            map[x-r1][y-c1] = 1;
        }
        while (isInRange(x, y)) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < length; j++) {
                    x += idx[dir];
                    y += idy[dir];
                    ++count;
                    if (r1 <= x && x <= r2 && c1 <= y && y <= c2) {
                        map[x - r1][y - c1] = count;
                        max = Math.max(max, count);
                    }
                }
                dir = (dir + 1) % 4;
            }
            length++;
        }
        int maxLen = String.valueOf(max).length();


        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                System.out.format("%" + maxLen + "d ", map[i][j]);
            }
            System.out.println();
        }

    }

    static boolean isInRange(int ndx, int ndy) {
        return ndx >= -5000 && ndy >= -5000 && ndx <= 5000 && ndy <= 5000;
    }

}
