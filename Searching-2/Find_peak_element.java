//Q-162@Leetcode

class Solution {
    public int binarySearch(int a[],int low,int high) {
        if(low>=high) return low;
        int mid = low + (high-low)/2;
        if(low == mid || high == mid){
            if(a[low] > a[high]) return low;
            else return high;
        }
        if(a[mid]>a[mid-1] && a[mid]>a[mid+1]) return mid;
        if(a[mid-1]>a[mid] && a[mid+1]>a[mid]) {
            int n = a.length-1;
            int l = mid+1;
            int r = (n-mid)+1;
            if(l<r) return binarySearch(a,low,mid-1);
            else return binarySearch(a,mid+1,high);
        }
        else if(mid-1>=0 && a[mid-1]>a[mid])
        return binarySearch(a,low,mid-1);
        else if(a[mid+1]>a[mid])
        return binarySearch(a,mid+1,high);
        else {
            if(a[low]>a[high]) return low;
            else return high;
        }
    }
    public int findPeakElement(int[] nums) {
        int indx = binarySearch(nums,0,nums.length-1);
        return indx;
    }
}