package week13;

import java.util.*;

class 가장많이받은선물 {

    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] arr = new int[n][n];
        Map<String, Integer> map = new HashMap<>(n);

        for(int i = 0; i<n; i++){
            map.put(friends[i], i);
        }

        for(int i = 0; i< gifts.length; i++){
            String[] str = gifts[i].split(" ");
            String giveStr = str[0];
            String takeStr = str[1];

            int giveInt = map.get(giveStr);
            int takeInt = map.get(takeStr);

            arr[giveInt][takeInt]++;
        }

        int[][] ans = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j<n; j++){
                if(arr[i][j] == 0) continue;

                ans[i][0] += arr[i][j];
                ans[j][1] += arr[i][j];
            }
        }

        for(int i = 0; i<n; i++){
            ans[i][2] = ans[i][0] - ans[i][1];
        }

        for(int i = 0; i < n; i++){
            int tmp = 0;
            for(int j = 0; j<n; j++){
                if(i == j) continue;
                if((arr[i][j] == 0 && arr[j][i] == 0) || (arr[i][j] == arr[j][i])){
                    if(ans[i][2] > ans[j][2]){
                        tmp++;
                    }
                } else {
                    if(arr[i][j] > arr[j][i]){
                        tmp++;
                    }
                }
            }
            answer = Math.max(tmp, answer);
        }


        return answer;
    }
}

