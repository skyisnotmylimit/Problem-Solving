//Q-2416@LeetCode
class TrieNode {
    Map<Character, TrieNode> links;
    boolean isWord;
    int count;
    TrieNode() {
        links = new HashMap<>();
        isWord = false;
        count = 0;
    }
    public boolean isEnd() {
        return isWord;
    }
    public void setEnd() {
        isWord = true;
    }
    public void put(char ch, TrieNode node) {
        links.put(ch, node);
    }
    public TrieNode get(char ch) {
        return links.get(ch);
    }
    public void addCount() {
        count++;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        int ans[] = new int[words.length];
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node.links.putIfAbsent(ch, new TrieNode());
                node = node.get(ch);
                node.addCount();
            }
            node.setEnd();
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode node = root;
            int score = 0;
            for (char ch : word.toCharArray()) {
                node = node.get(ch);
                score += node.count;
            }
            ans[i] = score;
        }
        return ans;
    }
}