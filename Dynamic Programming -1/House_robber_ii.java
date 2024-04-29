//Q-213@LeetCode
class Solution {
    private int rob(int nums[],int n,int dp[],int si) {
        if(n < si) return 0;
        if(n == si)
        return nums[n];
        if(dp[n] != -1) return dp[n];
        int take = nums[n] + rob(nums,n-2,dp,si);
        int ntake = 0 + rob(nums,n-1,dp,si);
        return dp[n] = Math.max(take,ntake);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        int a = rob(nums,nums.length-1,dp,1);
        Arrays.fill(dp,-1);
        int b = rob(nums,nums.length-2,dp,0);
        return Math.max(a,b);
    }
}