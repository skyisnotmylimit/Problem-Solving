//Q-81@Leetcode
class Solution {
    //Helper Function
    public boolean bsr(int a[],int low,int high,int tar) {
        if(low > high) return false;
        int mid = low + (high-low)/2;
        if(a[mid] == tar) return true; // element found at mid.
        if(a[low]<=a[mid] && a[mid]<=a[high]) {
            return bsr(a,low,mid-1,tar) || bsr(a,mid+1,high,tar); //if we can't tell in which half is sorted and target might be...so call both halves.
        }
        else if(a[low] <= a[mid]) { //finding the sorted and unsorted halves
            if(a[low]<=tar && tar<=a[mid])
            return bsr(a,low,mid-1,tar); //if target found in this sorted half..call the function for this.
            else
            return bsr(a,mid+1,high,tar); //else call the other half.
        }
        else{
            if(a[mid]<=tar && tar<=a[high])
            return bsr(a,mid+1,high,tar); //if target found in this half...call the function for this.
            else
            return bsr(a,low,mid-1,tar); //else call the other half.
        }
    }
    //Calling function
    public boolean search(int[] nums, int target) {
        return bsr(nums,0,nums.length-1,target);
    }
}
/*
 * Notes-
 * 1. this question is similar to Search in Rotated sorted array.
 * 2. just need to add an extra check when we can't tell which half of array is sorted and contains target.
 * 3. call both the halves in that case.
 */