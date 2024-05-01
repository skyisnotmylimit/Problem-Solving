//Q-45@LeetCode
class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
    private int solve(int nums[],int i,int dp[]) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int minJumps = Integer.MAX_VALUE;
        int maxSteps = nums[i];
        for (int j=1;j<=maxSteps;j++) {
            int ni = i + j;
            if (ni < nums.length) {
                int jumps = solve(nums,ni,dp);
                if (jumps != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps,jumps + 1);
                }
            }
        }
        return dp[i] = minJumps;
    }
}
