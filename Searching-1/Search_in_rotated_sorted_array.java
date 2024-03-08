//Q-33@Leetcode
class Solution {
    //Helper Function
    public boolean bsr(int a[],int low,int high,int tar) {
        if(low > high) return false;
        int mid = low + (high-low)/2;
        if(a[mid] == tar) return true; // element found at mid.
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
 * 1- Identify which half is sorted or unsorted
 * 2- In the sorted half..if the target is to be found..call it.
 * 3- Otherwise call the other half.
 */