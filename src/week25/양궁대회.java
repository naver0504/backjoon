package week25;

public class 양궁대회 {

    class Solution {

        int[] peach = new int[11];
        int[] lion = new int[11];
        int maxDif = 0;
        int[] answer = new int[11];
        int N;

        public int[] solution(int n, int[] info) {
            peach = info;
            N = n;
            dfs(0, 0);
            return maxDif == 0 ? new int[]{-1} : answer;
        }

        private void dfs(int depth, int score) {
            if(depth == N) {
                int dif = 0;
                for(int i = 0; i <= 10; i++) {
                    if(lion[i] == 0 && peach[i] == 0) continue;
                    if(lion[i] > peach[i]) dif += 10 - i;
                    else dif -= 10 - i;
                }

                if(dif > maxDif) {
                    for(int i = 0; i <= 10; i++) answer[i] = lion[i];
                    maxDif = dif;
                } else if(dif == maxDif) {
                    for(int i = 10; i >= 0; i--) {
                        if(lion[i] > answer[i]) break;
                        else if(lion[i] < answer[i]) {
                            for(int j = 0; j <= 10; j++) answer[i] = lion[i];
                            maxDif = dif;
                        }
                    }
                }
                return;
            }

            lion[score]++;
            dfs(depth + 1, score);
            lion[score]--;
            if(score <= 9)  dfs(depth, score + 1);
        }
    }
}
