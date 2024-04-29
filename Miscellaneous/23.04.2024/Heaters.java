//Q475@LeetCode
class Solution {
    public boolean blackBox(int houses[],int heaters[], int mid){
        int i = 0;
        int j = 0; 
        while (i < houses.length && j < heaters.length) {
            if (Math.abs(heaters[j] - houses[i]) <= mid) {
                i++; 
            } 
            else {
                j++;
            }
        }
        return (i == houses.length);
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int low = 0;
        int high = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (blackBox(houses,heaters,mid)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}