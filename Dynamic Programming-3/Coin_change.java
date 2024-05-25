//Q-322@LeetCode
class Solution {
    public int solve(int coins[],int amount,int dp[]){
        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0; 
        if (dp[amount] != -1) return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = solve(coins, amount - coin, dp);
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
        dp[amount] = minCoins;
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = solve(coins,amount,dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}