package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 일이삼더하기4_15989 {

    static int N;
    static int[] arr = {1, 2, 3};
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>(3);
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.forEach(
                value -> {
                    int[] tmpResult = new int[value+1];
                    tmpResult[0] = 1;
                    for (int i = 0; i < 3; i++) {
                        for(int j = 1; j <= value; j++) {
                            if(j >= arr[i]) {
                                tmpResult[j] += tmpResult[j - arr[i]];
                            }
                        }
                    }
                    sb.append(tmpResult[value]).append("\n");
                }
        );

        System.out.println(sb);



    }

}
