package week13;

public class 산모양타일링 {

    public int solution(int n, int[] tops) {

        int[][] dp = new int[n][2];

        dp[0][1] = 1;

        if(tops[0] == 1) {
            dp[0][0] = 3;
        } else {
            dp[0][0] = 2;
        }

        for(int i = 1; i < n; i++) {
            if(tops[i] == 0 ){
                dp[i][0] = (2 * dp[i-1][0] + dp[i-1][1]) % 10007;
                dp[i][1] = ((dp[i-1][0] + dp[i-1][1])) % 10007;
            } else {
                dp[i][0] = (3 * dp[i-1][0] + 2 * dp[i-1][1]) % 10007;
                dp[i][1] = ((dp[i-1][0] + dp[i-1][1])) % 10007;
            }
        }

        return (dp[n-1][0] + dp[n-1][1]) % 10007;
    }
}
