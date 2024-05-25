//Q-53@LeetCode
class Solution {
    public int maxSubArray(int[] nums) {
        int min_val = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            min_val = Math.max(min_val,sum);
            if(sum < 0) sum = 0;
        }
        return min_val;
    }
}