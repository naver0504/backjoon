package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 톱니바퀴14891 {

    static int[][] arr = new int[4][8];

    static int K;
    static int[] visited = new int[4];

    static class Rotate {
        int num;
        int dir;

        public Rotate(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }

    static List<Rotate> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<4; i++) {
            String line = br.readLine();
            for (int j = 0; j<8; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList<>(K);

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            list.add(new Rotate(num - 1, dir));
        }

        for (Rotate rotate : list) {
            int dir = rotate.dir;
            int num = rotate.num;

            visited[num] = 1;
            rotate(num, dir);
            visited[num] = 0;
        }

        int result = 0;

        if(arr[0][0] == 1) {
            result += 1;
        }
        if(arr[1][0] == 1) {
            result += 2;
        }
        if(arr[2][0] == 1) {
            result += 4;
        }
        if(arr[3][0] == 1) {
            result += 8;
        }

        System.out.println(result);


    }



    private static void rotate(int num, int dir) {


        if (num == 1 || num == 2) {
            if (arr[num][6] != arr[num - 1][2] && visited[num - 1] == 0) {
                visited[num - 1] = 1;
                rotate(num - 1, dir * -1);
                visited[num - 1] = 0;
            }

            if(arr[num][2] != arr[num + 1][6] && visited[num + 1] == 0) {
                visited[num + 1] = 1;
                rotate(num + 1, dir * -1);
                visited[num + 1] = 0;
            }
        } else if(num == 0) {
            if(arr[num][2] != arr[num + 1][6] && visited[num + 1] == 0) {
                visited[num + 1] = 1;
                rotate(num + 1, dir * -1);
                visited[num + 1] = 0;

            }
        } else {
            if (arr[num][6] != arr[num - 1][2] && visited[num - 1] == 0) {
                visited[num - 1] = 1;
                rotate(num - 1, dir * -1);
                visited[num - 1] = 0;
            }
        }



        if (dir == 1) {
            int tmpNS = arr[num][7];

            for (int i = 7; i > 0; i--) {
                arr[num][i] = arr[num][i - 1];
            }

            arr[num][0] = tmpNS;
            return;
        } else {
            int tmpNS = arr[num][0];

            for (int i = 0; i < 7; i++) {
                arr[num][i] = arr[num][i + 1];
            }

            arr[num][7] = tmpNS;
            return;
        }
    }


}
