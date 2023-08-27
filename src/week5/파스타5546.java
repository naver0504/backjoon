package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// TODO: 2023-08-25 모르겠다.
public class 파스타5546 {

    static int N;
    static int K;
    static long result = 0;
    static Set<String> set;

    static long[][][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        set = new HashSet<>();

        arr = new long[N+1][3][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int source = Integer.parseInt(st.nextToken());
            arr[day][source-1][0] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N-1; i++) {

            for(int j = 0; j < 3; j++){
                if (i == 1 || i == 2) {
                    if(arr[i][0][0] != 0 || arr[i][1][0] != 0 || arr[i][2][0] != 0){

                    }
                }

            }
        }


        System.out.println(result % 10000);




    }


}
