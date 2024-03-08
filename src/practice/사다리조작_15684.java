package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리조작_15684 {

    static int N;
    static int M;
    static int H;

    static int answer = -1;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;

            arr[row][col] = 1;
        }

        getAnswer(0);
        setArr(0, 1, 0);
        setArr(0, 2, 0);
        setArr(0, 3, 0);

        System.out.println(answer);

    }

    private static void setArr(int depth, int layer, int index) {
        if(answer != - 1) return;

        if (depth == layer) {
            getAnswer(layer);
            return;
        }

        for (int i = index; i < H * (N - 1); i++) {
            int row = i / (N -1);
            int col = i % (N - 1);

            if(answer != -1) break;
            if(arr[row][col] == 1) continue;
            if(arr[row][col + 1] == 1) continue;
            if(col != 0 && arr[row][col - 1] == 1) continue;
            arr[row][col] = 1;
            setArr(depth + 1, layer, i + 1);
            arr[row][col] = 0;

        }


    }

    private static void getAnswer(int layer) {
        for (int i = 0; i < N; i++) {
            int row = 0;
            int col = i;


            while(row != H) {

                if (col != 0) {
                    if (arr[row][col - 1] == 1) {
                        col--;
                    } else if (arr[row][col] == 1) {
                        col++;
                    }
                } else {
                    if ( arr[row][col] == 1) {
                        col++;
                    }
                }
                row++;
            }

            if(col != i) return;
        }

        answer = layer;
    }
}
