//Q-279@LeetCode
class Solution {
    public int solve(int n,int dp[]){
        if(n == 0)
        return 0;
        if(dp[n] != 0) return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<= n;i++) {
            int remaining = n - i * i;
            min = Math.min(min,solve(remaining,dp) + 1);
        }
        return dp[n] = min;
    }
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        return solve(n,dp);
    }
}