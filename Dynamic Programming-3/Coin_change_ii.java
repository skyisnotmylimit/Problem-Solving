//Q-518@LeetCode
class Solution {
    public int solve(int ind, int amount,int[] coins,int dp[][]) {
        if(ind == 0) {
            if(amount % coins[0] == 0) return 1;
            else return 0;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int ntake = 0 + solve(ind-1,amount - 0 , coins , dp);
        int take = 0;
        if(coins[ind] <= amount) take = solve(ind,amount-coins[ind],coins ,dp);
        return dp[ind][amount] = take + ntake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return solve(n-1,amount,coins,dp);
    }
}