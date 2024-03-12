//Q-1011@Leetcode
class Solution {
    public boolean blackBox(int a[],int d,int mid) {
        int total = 1;
        int sum = 0;
        int n = a.length;
        for(int i=0;i<n;i++) {
            sum = sum + a[i];
            if(sum > mid){
                total++;
                sum = a[i];
            }
        }
        return (total<=d);
    }
    public int shipWithinDays(int[] weights, int days) {
        int high = 0;
        int low = Integer.MIN_VALUE;
        for(int i : weights){
            low = Math.max(low,i);
            high = high + i;
        }
        int ans = 0;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(blackBox(weights,days,mid)){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}