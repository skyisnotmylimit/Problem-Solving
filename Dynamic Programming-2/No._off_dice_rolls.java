//Q-1155@LeetCode
class Solution {
    public static final int MOD = 1000000007;
    private int solve(int n,int k,int tar,int dp[][]) {
        if(n == 0 && tar == 0){
            return 1;
        }
        if (n == 0 || tar < 0) {
            return 0;
        }
        if(dp[n][tar] != -1) return dp[n][tar];
        int count = 0;
        for(int i=1;i<=k;i++) {
            if(tar - i >= 0)
            count = (count + solve(n-1,k,tar - i,dp)) % MOD;
        }
        return dp[n][tar] = count;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        for(int a[] : dp) {
            Arrays.fill(a,-1);
        }
        return solve(n,k,target,dp);
    }
}