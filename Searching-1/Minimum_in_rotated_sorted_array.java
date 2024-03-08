//Q-153@Leetcode

class Solution {
    //Helper Function
    public int searchPeak(int a[], int low, int high) {
        int mid = ((high - low) / 2) + low;
        if (a[low] <= a[mid] && a[mid] <= a[high]) return a[low]; 
        else if (a[mid] >= a[low]) {
            return searchPeak(a, mid+1,high);
        } else {
            return searchPeak(a,low,mid);
        }
    }
    //calling function
    public int findMin(int[] nums) {
        return searchPeak(nums, 0, nums.length - 1);
    }
}
/*Notes-
 * 1- find the mid.
 * 2. if array is sorted order return the a[low];
 * 3. otherwise discard the sorted half and search for the result in the other half.
 */