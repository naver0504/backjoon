package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class 사격_31264 {

    static int N;
    static int M;
    static int A;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            set.add(input);
            max = Math.max(max, input);
        }

        for (int i = 1; i <= max; i++) {
            int currentPoint = i;
            for (int j = 0; j < M && currentPoint - i < A; j++) {
                if (set.contains(currentPoint)) {
                    currentPoint += currentPoint;
                } else {
                    int tmp = currentPoint;
                    while (--tmp > 0) {
                        if (max < tmp) tmp = max;
                        if (set.contains(tmp)) {
                            currentPoint += tmp;
                            break;
                        }
                    }
                }
            }

            if (currentPoint  - i >= A) {
                System.out.println(i);
                break;
            }
        }
    }

}
