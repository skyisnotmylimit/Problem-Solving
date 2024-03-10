//Q-1482@Leetcode
class Solution {
    public boolean blackBox(int a[],int m,int k,int mid) {
        int i = 0;
        int n = a.length;
        int total = 0;
        while(i<n && m>0){
            if(a[i] <= mid){
                total++;
                if(total == k){
                    m--;
                    total = 0;
                }
            }
            else {
                total = 0;
            }
            i++;
        }
        if(m == 0) return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)bloomDay.length < ((long)m*k)) return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i : bloomDay){
            low = Math.min(low,i);
            high = Math.max(high,i);
        }
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(blackBox(bloomDay,m,k,mid)) {
                ans = Math.min(ans,mid);
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}