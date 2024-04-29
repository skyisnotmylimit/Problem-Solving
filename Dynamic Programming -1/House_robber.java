//Q-198@LeetCode
class Solution {
    private int rob(int nums[],int n,int dp[]) {
        if(n < 0) return 0;
        if(n == 0)
        return nums[n];
        if(dp[n] != -1) return dp[n];
        int take = nums[n] + rob(nums,n-2,dp);
        int ntake = 0 + rob(nums,n-1,dp);
        return dp[n] = Math.max(take,ntake);
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return rob(nums,nums.length-1,dp);
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int a = 0;
        int b = nums[0];
        int c = 0;
        for(int i=1;i<nums.length;i++) {
            int ntake = 0 + b;
            int take = nums[i] + a;
            c = Math.max(take,ntake);
            a = b;
            b = c;
        }
        return c;
    }
}