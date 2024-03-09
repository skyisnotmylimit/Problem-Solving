//Q-540@Leetcode

class Solution {
    public int binarySearch(int a[],int low,int high) {
        if(low >= high) return low;
        int mid = low + (high-low)/2;
        if(a[mid] != a[mid-1] && a[mid] != a[mid+1]) return mid;
        if(mid%2 == 0) {
            if(a[mid] != a[mid-1]){
                return binarySearch(a,mid+2,high);
            }
            else {
                return binarySearch(a,low,mid-2);
            }
        }
        else {
            if(a[mid] != a[mid-1]) {
                return binarySearch(a,low,mid-1);
            }
            else {
                return binarySearch(a,mid+1,high);
            }
        }

    }
    public int singleNonDuplicate(int[] nums) {
        int indx = binarySearch(nums,0,nums.length-1);
        return nums[indx];
    }
}