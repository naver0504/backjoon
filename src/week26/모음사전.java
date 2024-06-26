package week26;

import java.util.ArrayList;
import java.util.List;

public class 모음사전 {

    class Solution {

        List<String> list = new ArrayList<>();
        String[] alphas = new String[] {"A", "E", "I", "O", "U"};

        public int solution(String word) {
            setAlpha("", 0);
            for(int i = 0; i < list.size(); i++) {
                if(word.equals(list.get(i))) return i + 1;
            }
            return 0;
        }

        public void setAlpha(String s, int length) {
            if(length == 5) return;
            for (int i = 0; i < 5; i++) {
                String alpha = s + alphas[i];
                list.add(alpha);
                setAlpha(alpha, length + 1);
            }
        }
    }
}
