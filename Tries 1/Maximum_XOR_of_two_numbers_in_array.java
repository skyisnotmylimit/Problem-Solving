//Q-421@LeetCode
class TrieNode {
    TrieNode[] links;
    TrieNode() {
        links = new TrieNode[2];
    }
    public void put(TrieNode node,int i) {
        links[i] = node;
    }
    public TrieNode get(int i) {
        return links[i];
    }
    public boolean containsKey(int i) {
        return (links[i] != null);
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for(int num : nums) {
            TrieNode node = root;
            int x = num;
            for(int i = 31; i >= 0; i--) { 
                int bit = (x >> i) & 1; 
                if(!node.containsKey(bit)) {
                    node.put(new TrieNode(),bit);
                }
                node = node.get(bit);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            TrieNode node = root;
            int curMax = 0;
            int x = num;
            int y = 0;
            for(int i=31;i>=0;i--) {
                int bit = (x >> i) & 1;
                int inv = (bit == 0)?1:0;
                if(node.containsKey(inv)) {
                    if(inv == 1)
                    y = y + (1 << i);
                    node = node.get(inv);
                }
                else {
                    if(bit == 1)
                    y = y + (1 << i);
                    node = node.get(bit);
                }
            }
            curMax = x ^ y;
            max = Math.max(curMax,max);
        }
        return max;
    }
}