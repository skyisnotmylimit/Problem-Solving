//Q-34@Leetcode

class Solution {
    public int findLast(int a[],int low,int high,int tar) { //to find the last index.
        if(low > high) return -1;
        int mid = low + (high-low)/2; 
        if(a[mid] == tar) { //if target found
            if(mid<a.length-1 && a[mid+1] == tar) //to see if moving right from mid we can find more elements or not.
            return findLast(a,mid+1,high,tar);// call for the right half if found.
            else return mid; //return current index otherwise.
        }
        if(a[mid]>tar)
        return findLast(a,low,mid-1,tar);
        else return findLast(a,mid+1,high,tar);
    }
    public int findFirst(int a[],int low,int high,int tar) { //to find the first index.
        if(low > high) return -1;
        int mid = low + (high-low)/2;
        if(a[mid] == tar) {
            if(mid > 0 && a[mid-1] == tar) //to see if on moving left we can find more elements or not.
            return findFirst(a,low,mid-1,tar);// call for the right part if found.
            else return mid; //return this index otherwise.
        }
        if(a[mid]>tar)
        return findFirst(a,low,mid-1,tar);
        else return findFirst(a,mid+1,high,tar);
    }

    //calling function
    public int[] searchRange(int[] nums, int target) {
        int l = findFirst(nums,0,nums.length-1,target);
        int r = -1;
        if(l != -1)
        r = findLast(nums,0,nums.length-1,target);
        int ans[] = new int[2];
        ans[0] = l;
        ans[1] = r;
        return ans;
    }
}
/*
 * Notes-
 * 1. Similar to binary searching.
 * 2. Here modification is made by making 2 binary searchs..one to get the first index...another to get the last index.
 * 3. During both searches..we do not stop the search if we find the element at mid..instead, we will continue to search
 *    for a better index in that half of the array where target is probable to be found.
 */