package week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 고층건물 {

    static int[] buildings;
    static int[] answers;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        buildings = new int[N];
        answers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            double curMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < N; j++) {
                double cur = (double) (buildings[j] - buildings[i]) /(j - i);
                if (cur > curMax) {
                    curMax = cur;
                    answers[i]++;
                    answers[j]++;
                }
            }


        }
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, answers[i]);
        }
        System.out.println(answer);
    }
}
