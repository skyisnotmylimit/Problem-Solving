//Q-2915@LeetCode
class Solution {
    public int solve(List<Integer> nums,int tar, int ind, int n,int dp[][]) {
        if(tar==0) return 0;
        if(ind==n || tar<0) return -9999;
        if(dp[ind][tar] != -1) return dp[ind][tar];
        int take = 1 + solve(nums,tar-nums.get(ind),ind+1,n,dp);
        int ntake = solve(nums,tar,ind+1,n,dp);
        return dp[ind][tar] = Math.max(take,ntake);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = Math.max(target+1,nums.size());
        int dp[][] = new int[n][n];
        for(int i=0;i<dp.length;i++) 
        Arrays.fill(dp[i],-1);
        int ans = solve(nums,target,0,nums.size(),dp);
        if(ans<0) return -1;
        return ans;
    }
}