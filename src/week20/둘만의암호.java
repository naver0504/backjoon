package week20;

public class 둘만의암호 {

    class Solution {
        public String solution(String s, String skip, int index) {


            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int count = 0;
                while(count < index) {
                    c = c == 'z' ? 'a' : (char) (c + 1);
                    count++;
                    if(skip.contains(String.valueOf(c))) {
                        count--;
                    }
                }

                sb.append(c);

            }

            return sb.toString();
        }
    }
}
