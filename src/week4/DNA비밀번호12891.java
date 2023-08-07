package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호12891 {

    static int s;
    static int p;
    static int A;
    static int C;
    static int G;
    static int T;
    static String line;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        line = br.readLine();
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


        int tmpA = 0;
        int tmpC = 0;
        int tmpG = 0;
        int tmpT = 0;
        for (int i = 0; i < p; i++) {
            switch (line.charAt(i)) {
                case 'A':
                    tmpA++;
                    break;
                case 'C':
                    tmpC++;
                    break;
                case 'G':
                    tmpG++;
                    break;
                case 'T':
                    tmpT++;
                    break;
            }


        }
        plusResult(tmpA, tmpC, tmpG, tmpT);

        for(int i = 1; i<=s-p; i++) {
           switch (line.charAt(i-1)) {
               case 'A':
                   tmpA--;
                   break;
               case 'C':
                   tmpC--;
                   break;
               case 'G':
                   tmpG--;
                   break;
               case 'T':
                   tmpT--;
                   break;
              }
           switch (line.charAt(i+p-1)) {
                case 'A':
                    tmpA++;
                    break;
                case 'C':
                    tmpC++;
                    break;
                case 'G':
                    tmpG++;
                    break;
                case 'T':
                    tmpT++;
                    break;
            }
            plusResult(tmpA, tmpC, tmpG, tmpT);
        }

        System.out.println(result);

    }

    private static void plusResult(int tmpA, int tmpC, int tmpG, int tmpT) {
        if (tmpA >= A && tmpC >= C && tmpG >= G && tmpT >= T) {
            result++;
        }
    }
}
