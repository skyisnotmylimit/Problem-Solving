//Q-1760@Leetcode
class Solution {
    public boolean blackBox(int a[], int mx, int mid) {
        int total = 0;
        for (int i = 0;i<a.length;i++) {
            if (a[i] > mid) {
                total += (a[i]-1)/mid;
                if (total > mx) return false;
            }
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOp) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i : nums) {
            high = Math.max(i, high);
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (blackBox(nums, maxOp, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}