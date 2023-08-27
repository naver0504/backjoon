package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동물원1309 {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        
//            1 2 = 3
//            1 4 2 = 7
//            1 6 8 2 = 17
//            1 8 14 16 2 = 41

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        arr[1] = 3;
        if(N == 1){
            System.out.println(arr[1]);
            return;
        }
        arr[2] = 7;
        if(N == 2){
            System.out.println(arr[2]);
            return;
        }
        for(int i = 3; i<= N; i++){
            arr[i] = (arr[i-1] * 2 % 9901  + arr[i-2] % 9901) % 9901;
        }

        System.out.println(arr[N]);


    }
}
