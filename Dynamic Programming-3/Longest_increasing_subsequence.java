//Q-300@LeetCode
class Solution {
    private int solve(int i, int prev, int[] nums,int dp[][]) {
        if (i >= nums.length) 
        return 0;
        if(dp[i][prev+1] != 0) return dp[i][prev+1];
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(i + 1, i, nums,dp);
        }
        int ntake = solve(i + 1, prev, nums,dp);
        dp[i][prev+1] = Math.max(take, ntake);
        return dp[i][prev+1];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        return solve(0, -1, nums,dp);
    }
}
class Solution {
    public int lengthOfLIS(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        int max = 1;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++) {
            for(int j=0;j<=i-1;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
