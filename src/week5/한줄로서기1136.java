package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한줄로서기1136 {


    static int N;
    static int[] person;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        person = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int left = Integer.parseInt(st.nextToken());
            int index = 0;

            for (int j = 0; j < N; j++) {
                if (index == left && person[j] == 0) {
                    person[j] = i + 1;
                    break;
                } else {
                    if (person[j] == 0) {
                        index++;
                    }
                }


            }
        }

        for (int i = 0; i < N; i++) {
            if(person[i] == 0)
                person[i] = N;
        }

        for(int i = 0; i < N; i++) {
            System.out.print(person[i] + " ");
        }
    }
}
