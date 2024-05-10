//Q-63@LeetCode
class Solution {
    public int solve(int grid[][],int m,int n,int dp[][]) {
        if(grid[m][n] == 1) return 0;
        if(m == 0 && n == 0)
        return 1;
        if(dp[m][n] != 0) return dp[m][n];
        int total;
        if(m == 0) {
            total = solve(grid,m,n-1,dp);
        }
        else if(n == 0) {
            total = solve(grid,m-1,n,dp);
        }
        else{
            int up = solve(grid,m-1,n,dp);
            int left = solve(grid,m,n-1,dp);
            total = up + left;
        }
        dp[m][n] = total;
        return total;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        return solve(grid,m-1,n-1,dp);
    }
}