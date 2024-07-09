package week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 암호만들기_1759 {

    static int L;
    static int C;
    static String[] alphas;

    static Set<String> set = Set.of("a", "e", "i", "o", "u");
    static Set<String> answers = new HashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphas = new String[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphas[i] = st.nextToken();
        }
        Arrays.sort(alphas);

        backTracking(0, 0, 0, new ArrayList<>());
        List<String> answersList = new ArrayList<>(answers);
        answersList.sort(String::compareTo);
        answersList.forEach(System.out::println);


    }

    public static void backTracking(int depth, int startIdx, int vowels, List<String> alphabets) {
        if (depth == L) {
            int size = alphabets.size();
            if(vowels < 1 || size - vowels < 2) return;
            StringBuilder sb = new StringBuilder();
            alphabets.sort(String::compareTo);
            alphabets.forEach(sb::append);
            answers.add(sb.toString());
            return;
        }

        for (int i = startIdx; i < C; i++) {
            String value = alphas[i];
            alphabets.add(value);
            if (set.contains(value)) {
                backTracking(depth + 1, i + 1, vowels + 1, alphabets);
            } else {
                backTracking(depth + 1, i + 1, vowels, alphabets);
            }
            alphabets.remove(value);
        }
    }
}
