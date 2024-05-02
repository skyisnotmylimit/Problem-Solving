//@GFG
public class Solution {
    public int solve(int n, int[][] mat, int r, int c, int[][] dp) {
        if (c >= n)
        return 0;
        if (dp[r][c] != -1)
        return dp[r][c];
        int t1 = mat[r][c] + Math.max(solve(n, mat, 1, c + 2, dp), solve(n, mat, 0, c + 2, dp));
        int t2 = solve(n, mat, 1, c + 1, dp);
        int t3 = solve(n, mat, 0, c + 1, dp);
        return dp[r][c] = Math.max(t1, Math.max(t2, t3));
    }
    public int maxSum(int n, int[][] mat) {
        int[][] dp = new int[3][n + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return Math.max(solve(n, mat, 0, 0, dp), solve(n, mat, 1, 0, dp));
    }
}
