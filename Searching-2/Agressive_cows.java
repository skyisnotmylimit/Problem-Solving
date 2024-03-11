//Q-1552@Leetcode
import java.util.*;
class Solution {
    public boolean blackBox(int A[], int mid, int m) {
        int initial = 1;
        int prev = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] - prev >= mid) {
                prev = A[i];
                initial += 1;
                if (initial == m) return true;
            }
        }
        if (initial < m) return false;
        return true;
    }
    public int maxDistance(int[] A, int m) {
        Arrays.sort(A);
        int n = A.length;
        int low = 0;
        int high = A[n-1];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (blackBox(A, mid, m)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
