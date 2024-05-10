//Q-174@LeetCode
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];
        return solve(dungeon, 0, 0, dp);
    }
    public int solve(int dungeon[][], int row, int col, int dp[][]) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        if (row == m - 1 && col == n - 1) {
            dp[row][col] = Math.max(1, 1 - dungeon[row][col]);
            return dp[row][col];
        }
        int right = (col < n - 1) ? solve(dungeon, row, col + 1, dp) : Integer.MAX_VALUE;
        int down = (row < m - 1) ? solve(dungeon, row + 1, col, dp) : Integer.MAX_VALUE;
        int minHealth = Math.min(right, down) - dungeon[row][col];
        dp[row][col] = Math.max(1, minHealth);
        return dp[row][col];
    }
}
