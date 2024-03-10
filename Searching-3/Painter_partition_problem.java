//@CodingNinja
import java.util.ArrayList;
public class Solution {
    public static boolean blackBox(ArrayList<Integer> a,int k,int mid) {
        int total = 1;
        int sum = 0;
        int n = a.size();
        for(int i=0;i<n;i++) {
            sum = sum + a.get(i);
            if(sum > mid){
                total++;
                sum = a.get(i);
            }
        }
        return (total<=k);
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
         int high = 0;
         int low = Integer.MIN_VALUE;
         for(int i : boards) {
             low = Math.max(i,low);
             high = high + i;
         }
         int ans = Integer.MAX_VALUE;
         while(low <= high) {
             int mid = low + (high-low)/2;
             if(blackBox(boards,k,mid)) {
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