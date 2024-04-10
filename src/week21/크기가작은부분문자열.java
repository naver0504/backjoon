package week21;

import java.util.ArrayList;
import java.util.List;

public class 크기가작은부분문자열 {

    class Solution {

        List<Long> list = new ArrayList<>();
        public int solution(String t, String p) {
            long pValue = Long.valueOf(p);
            int length = p.length();
            int answer = 0;

            for(int i = 0; i< t.length() - length + 1; i++) {
                long tValue = Long.valueOf(t.substring(i, i + length));
                if(tValue <= pValue) answer++;
            }

            return answer;
        }
    }
}
