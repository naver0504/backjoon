package week16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보수집유효기간 {
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {

            int nowYear = Integer.parseInt(today.substring(0, 4));
            int nowMonth = Integer.parseInt(today.substring(5, 7));
            int nowDay = Integer.parseInt(today.substring(8, 10));

            Map<String, Integer> map = new HashMap<>(terms.length);
            for(int i = 0; i< terms.length; i++) {
                String[] term = terms[i].split(" ");
                map.put(term[0], Integer.parseInt(term[1]));
            }

            List<Integer> addList = new ArrayList<>();

            for(int i = 0; i<privacies.length; i++) {
                String[] privaciesDayAndTerm = privacies[i].split(" ");
                String privaciesDay = privaciesDayAndTerm[0];
                String term = privaciesDayAndTerm[1];

                int thisYear = Integer.parseInt(privaciesDay.substring(0, 4));
                int thisMonth = Integer.parseInt(privaciesDay.substring(5, 7));
                int thisDay = Integer.parseInt(privaciesDay.substring(8, 10));

                int plusMonth = map.get(term);
                if(thisDay - 1 == 0) {
                    thisMonth += plusMonth - 1;
                    thisDay = 28;
                } else {
                    thisMonth += plusMonth;
                    thisDay--;
                }

                if(thisMonth > 12) {

                    int left = thisMonth / 12 ;
                    int right = thisMonth % 12;

                    if(right == 0) {
                        left -= 1;
                        right = 12;
                    }


                    thisYear += left;
                    thisMonth = right;
                }


                if(thisYear < nowYear) {
                    addList.add(i+1);
                } else if(thisYear == nowYear) {
                    if(thisMonth < nowMonth) {
                        addList.add(i+1);
                    } else if(thisMonth == nowMonth){
                        if(thisDay < nowDay)
                            addList.add(i+1);
                    }
                }


            }

            int[] answer = new int[addList.size()];
            int currentIdx = 0;
            for(int index : addList) {
                answer[currentIdx++] = index;
            }
            return answer;
        }
    }
}
