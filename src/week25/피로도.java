package week25;

public class 피로도 {

    class Solution {

        int[][] base;
        int depth;
        int answer = 0;
        boolean[] visited;

        public int solution(int k, int[][] dungeons) {
            base = dungeons;
            depth = dungeons.length;
            visited = new boolean[depth];
            dfs(0, k);
            return answer;
        }

        public void dfs(int curDepth, int curK) {
            for(int i = 0; i < depth; i++) {
                if(visited[i]) continue;
                if(curK < base[i][0]) continue;
                else {
                    visited[i] = true;
                    dfs(curDepth + 1, curK - base[i][1]);
                    visited[i] = false;
                }
            }
            answer = Math.max(curDepth, answer);
        }
    }
}
