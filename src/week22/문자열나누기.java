package week22;

public class 문자열나누기 {
    class Solution {
        public int solution(String s) {

            char startC = 'A';
            int x = 1;
            int y = 0;
            int answer = 0;

            for(int i = 0; i < s.length(); i++) {

                if(startC == 'A') {
                    startC = s.charAt(i);
                    x = 1;
                    y = 0;
                    continue;
                }
                char c = s.charAt(i);
                if(startC == c) {
                    x++;
                } else {
                    y++;
                }

                if(x == y) {
                    answer++;
                    startC = 'A';
                }
            }

            if(x != y) answer++;
            return answer;
        }
    }
}
