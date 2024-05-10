//Q-62@LeetCode
class Solution {
    public int solve(int m,int n,int dp[][]) {
        if(m == 0 && n == 0)
        return 1;
        if(dp[m][n] != 0) return dp[m][n];
        int total;
        if(m == 0) {
            total = solve(m,n-1,dp);
        }
        else if(n == 0) {
            total = solve(m-1,n,dp);
        }
        else{
            int up = solve(m-1,n,dp);
            int left = solve(m,n-1,dp);
            total = up + left;
        }
        dp[m][n] = total;
        return total;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        return solve(m-1,n-1,dp);
    }
}