//Q-70@LeetCode
class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairs(n,dp);
    }
    private int climbStairs(int n,int dp[]) {
        if (n < 0) return 0;
        if (n <= 1) 
        return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = climbStairs(n - 1,dp) + climbStairs(n - 2,dp);
    }
}
class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i=2;i<=n;i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}