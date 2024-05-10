//Q-64@LeetCode
class Solution {
    public int solve(int grid[][],int m,int n,int dp[][]){
        if(m == 0 && n == 0)
        return grid[0][0];
        if(m < 0 && n < 0 && m >= grid.length && n >= grid[0].length)
        return Integer.MAX_VALUE;
        if(dp[m][n] != 0) 
        return dp[m][n];
        int minPath;
        if(m == 0) {
            minPath = solve(grid,m,n-1,dp);
        }
        else if(n == 0){
            minPath = solve(grid,m-1,n,dp);
        }
        else{
            int up = solve(grid,m-1,n,dp);
            int left = solve(grid,m,n-1,dp);
            minPath = Math.min(up,left);
        }
        minPath = minPath + grid[m][n];
        dp[m][n] = minPath;
        return minPath;
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        return solve(grid,m-1,n-1,dp);
    }
}