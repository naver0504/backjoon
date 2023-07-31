package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트 {

    private static int time = Integer.MAX_VALUE;
    private static int height;
    private static int[][] array;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {


        int n;
        int m;
        int b;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = getInteger(st.nextToken());
        m = getInteger(st.nextToken());
        b = getInteger(st.nextToken());

        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                array[i][j] = getInteger(st.nextToken());
                setMaxAndMin(i, j);
                j++;
            }
        }
        for (int k = min; k <= max; k++) {
            int tmpInventory = b;
            int tmpTime = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (array[i][j] > k) {
                        int dif = array[i][j] - k;
                        tmpTime += dif * 2;
                        tmpInventory += dif;
                    } else if ( array[i][j] < k){
                        int dif = k - array[i][j];
                        tmpTime += dif;
                        tmpInventory -= dif;
                    }
                }
            }
            setTimeAndHeight(k, tmpInventory, tmpTime);
        }

        printResult();

    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(time).append(" ").append(height);
        System.out.println(sb);
    }

    private static void setTimeAndHeight(int k, int tmpInventory, int tmpTime) {
        if (tmpInventory >= 0) {
            if (tmpTime <= time) {
                time = tmpTime;
                height = k;
            }
        }
    }

    private static void setMaxAndMin(int i, int j) {
        max = Math.max(max, array[i][j]);
        min = Math.min(min, array[i][j]);
    }

    private static int getInteger(String s) {
        return Integer.parseInt(s);
    }
}
