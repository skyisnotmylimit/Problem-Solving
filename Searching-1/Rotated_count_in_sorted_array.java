// @GFG
//helper function
class Solution {
    int searchPeak(int a[],int low,int high) {
        int mid = low + (high-low)/2;
        if(a[low]<=a[mid] && a[mid]<=a[high]) return low; //Returning index instead of element if found
        else if(a[mid] >= a[low])
        return searchPeak(a,mid+1,high);
        else
        return searchPeak(a,low,mid);
    }
    //calling function
    int findKRotation(int arr[], int n) {
        return searchPeak(arr,0,n-1);
    }
}
/*
 * Notes-
 * 1- Similar question of finding the minimum element in the sorted array.
 * 2. Return index of minimum as the answer instead of the element.
 */