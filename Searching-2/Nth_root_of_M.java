//@GFG
class Solution {
    public int NthRoot(int n, int m) {
        // code here
        int start=1;
        int end=m;
        while(start<=end) {
            int mid=start+(end-start)/n;
            long num=(long)Math.pow(mid,n);
            if(num==m)
            return mid;
            else if(num<m)
            start=mid+1;
            else
            end=mid-1;
        }
        return -1;
    }
}
