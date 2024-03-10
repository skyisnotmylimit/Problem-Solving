//Q-1208@Leetcode
class Solution {
    public int maxLengthSubarrayWithSumLessThanOrEqualToK(int[] arr, int k) {
        int maxLength = 0;
        int currentSum = 0;
        int start = 0;
        for(int end=0;end<arr.length;end++) {
            currentSum += arr[end];
            while (currentSum>k && start<=end) {
                currentSum -= arr[start];
                start++;
            }
            int currentLength = end - start + 1;
            maxLength = Math.max(maxLength,currentLength);
        }
        return maxLength;
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int a[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            a[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        return maxLengthSubarrayWithSumLessThanOrEqualToK(a,maxCost);
    }
}
