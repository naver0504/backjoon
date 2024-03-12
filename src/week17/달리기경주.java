package week17;

import java.util.ArrayList;
import java.util.List;

public class 달리기경주 {

    class Solution {

        class Person {
            String name;
            int idx;

            Person(String name, int idx) {
                this.name = name;
                this.idx= idx;
            }

        }

        static List<Person> list;
        public String[] solution(String[] players, String[] callings) {
            list = new ArrayList<>(players.length);

            for(int i = 0; i<players.length; i++) {
                list.add(new Person(players[i], i));
            }

            list.sort((o1, o2) -> o1.name.compareTo(o2.name));

            for(String call : callings) {
                int target = find(call);
                Person p = list.get(target);
                int org = p.idx;
                int pre = p.idx - 1;

                swap(players[pre], p);
                swap(pre, org, players);
            }

            return players;
        }

        private void swap(String preCall, Person p) {
            int pre = find(preCall);
            Person p1 = list.get(pre);

            int tmp = p1.idx;
            p1.idx = p.idx;
            p.idx = tmp;
        }

        private void swap(int pre, int next, String[] players) {
            String tmp = players[pre];
            players[pre] = players[next];
            players[next] = tmp;
        }

        private int find(String call) {
            int start = 0;
            int end = list.size() -1;

            while(start <= end) {
                int mid = (start + end) / 2;
                Person p = list.get(mid);
                if(p.name.compareTo(call) > 0) {
                    end = mid - 1;
                } else if(p.name.compareTo(call) < 0) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }

            return start;
        }

    }
}
