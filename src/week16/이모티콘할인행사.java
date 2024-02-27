package week16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 이모티콘할인행사 {

    class Solution {

        int[] percentage = {40, 30, 20, 10};
        List<Node> list = new ArrayList<>();
        int[][] users;
        int[] emoticons;
        int length = 0;

        static class Node {
            int service = 0;
            int price = 0;

            Node(int service, int price) {
                this.service = service;
                this.price = price;
            }
        }
        public int[] solution(int[][] users, int[] emoticons) {
            length = emoticons.length;
            this.users = users;
            int[] arr = new int[length];
            this.emoticons = emoticons;

            getAnswer(0, arr);
            Collections.sort(list, (o1, o2) -> {
                if(o1.service == o2.service) {
                    return o2.price - o1.price;
                } else {
                    return o2.service - o1.service;
                }
            });


            int[] answer = new int[2];
            answer[0] = list.get(0).service;
            answer[1] = list.get(0).price;


            return answer;


        }

        private void getAnswer(int depth, int[] arr) {
            if(depth == length) {


                addList(arr);
                return;
            }

            int[] tmp = new int[length];
            for(int i = 0; i< depth; i++) {
                tmp[i] = arr[i];
            }

            for(int i = 0; i < 4; i++) {
                tmp[depth] = percentage[i];
                getAnswer(depth + 1 , tmp);
                tmp[depth] = 0;
            }

        }

        private void addList(int[] arr) {
            int service = 0;
            int price = 0;


            for(int i = 0; i<users.length; i++) {
                int userPer = users[i][0];
                int userPrice = users[i][1];
                int emo = 0;
                for(int j = 0; j < length; j++) {
                    if(arr[j] < userPer) continue;
                    emo += emoticons[j] * (100 - arr[j]) / 100;

                }

                if(emo >= userPrice) service++;
                else price += emo;

            }


            list.add(new Node(service, price));
        }
    }
}
