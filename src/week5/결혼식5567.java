package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 결혼식5567 {


    static Map<Integer, Integer> map;
    static ArrayList<Friend> list ;

    static class Friend {
        int left;
        int right;

        public Friend(int left, int right) {
            this.left = left;
            this.right = right;
        }

    }

    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList<>(M);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            list.add(new Friend(left, right));
        }


        list.sort((o1, o2) -> {
            if(o1.left == 1 || o1.right == 1) {
                return -1;
            }
            return o1.left - o2.left;
        });

        map = new HashMap<>(M);

        int result = 0;

        for(int i = 0; i < M; i++) {
            int left = list.get(i).left;
            int right = list.get(i).right;

            if(left == 1) {
                map.put(right, 1);
                result++;
                continue;
            }
            if(right == 1) {
                map.put(left, 1);
                result++;
                continue;
            }

            boolean isFriendLeft = map.containsKey(left);
            boolean isFriendRight = map.containsKey(right);

            if(isFriendLeft && !isFriendRight) {
                int isFriend = map.get(left);
                if(isFriend == 1) {
                    map.put(right, 2);
                    result++;
                }
                continue;
            }

            if(isFriendRight && !isFriendLeft) {
                int isFriend = map.get(right);
                if(isFriend == 1) {
                    map.put(left, 2);
                    result++;
                }
                continue;
            }
        }

        System.out.println(result);


    }
}
