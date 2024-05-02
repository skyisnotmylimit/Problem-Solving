//Q-904@LeetCode
class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < fruits.length; end++) {
            int current = fruits[end];
            map.put(current, map.getOrDefault(current, 0) + 1);
            while (map.size() > 2) {
                int startFruit = fruits[start];
                map.put(startFruit, map.get(startFruit) - 1);
                if (map.get(startFruit) == 0) {
                    map.remove(startFruit);
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}