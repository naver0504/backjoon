package week31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 거짓말_1043 {

    static int N;
    static int M;
    static boolean[] tellTrue;
    static Set<Integer> knowTruthSet = new HashSet<>();
    static List<List<Integer>> lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tellTrue = new boolean[M];
        lines = new ArrayList<>(M);

        st = new StringTokenizer(br.readLine());
        int knowTruth = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowTruth; i++) {
            int personIdx = Integer.parseInt(st.nextToken());
            knowTruthSet.add(personIdx);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            List<Integer> line = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                int personIdx = Integer.parseInt(st.nextToken());
                line.add(personIdx);
            }
            lines.add(line);
        }

        while (true) {
            boolean isChanged = false;
            for (int i = 0; i < lines.size(); i++) {
                if(tellTrue[i]) continue;
                List<Integer> line = lines.get(i);
                boolean tellTruth = false;
                for (Integer idx : line) {
                    if (knowTruthSet.contains(idx)) {
                        tellTruth = true;
                        break;
                    }
                }

                if (tellTruth) {
                    knowTruthSet.addAll(line);
                    tellTrue[i] = true;
                    isChanged = true;
                }
            }

            if(!isChanged) break;
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if(!tellTrue[i]) answer++;
        }

        System.out.println(answer);

    }
}
