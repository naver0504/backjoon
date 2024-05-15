package week24;

public class 이차원동전뒤집기 {

    class Solution {

        int row;
        int col;
        int answer = Integer.MAX_VALUE;
        int[][] tar;
        public int solution(int[][] beginning, int[][] target) {
            row = beginning.length;
            col = beginning[0].length;
            tar = target;

            dfs(0 ,beginning, 0);

            return answer == Integer.MAX_VALUE ? -1 : answer;
        }

        private void dfs(int rowNum, int[][] arr, int count) {
            if(rowNum == row) {
                int res = 0;

                for(int i = 0; i < col; i++) {
                    int same = 0;
                    for(int j = 0; j < row; j++) {
                        if(arr[j][i] == tar[j][i]) same++;
                    }
                    if(same == 0) {
                        res++;
                    }
                    else if(same != row) return;
                }

                answer = Math.min(res + count, answer);
                return;
            }

            flipRow(rowNum, arr);
            dfs(rowNum + 1, arr, count + 1);
            flipRow(rowNum, arr);
            dfs(rowNum + 1, arr, count);
        }

        private void flipRow(int row, int[][] arr) {
            for(int i = 0; i < col; i++) {
                arr[row][i] = arr[row][i] == 1 ? 0 : 1;
            }
        }

        private void flipCol(int col, int[][] arr) {
            for(int i = 0; i < row; i++) {
                arr[i][col] = arr[i][col] == 1 ? 0 : 1;
            }
        }
    }
}
