//@GFG
class Solution {
    public static final int MOD = 1000000007;
    public long solve(int n,long dp[]) {
        if(n <= 2)
        return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = (solve(n-1,dp) + (n-1)*solve(n-2,dp))%MOD;
    }
    public long countFriendsPairings(int n) {
        long dp[] = new long[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}