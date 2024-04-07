//Q-2416@LeetCode
class TrieNode {
    TrieNode links[];
    boolean isWord;
    int count;
    TrieNode() {
        links = new TrieNode[26];
        isWord = false;
        count = 0;
    }
    public boolean isEnd() {
        return isWord;
    }
    public void setEnd() {
        isWord = true;
    }
    public void put(TrieNode node,char ch) {
        if(links[ch - 'a'] == null) {
            links[ch - 'a'] = node;
        }
    }
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    public void addCount() {
        count++;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        int ans[] = new int[words.length];
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                if(node.get(ch) == null) {
                    node.put(new TrieNode(),ch);
                }
                node = node.get(ch);
                node.addCount();
            }
            node.setEnd();
        }
        for(int i=0;i<words.length;i++) {
            String word = words[i];
            int score = 0;
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                node = node.get(ch);
                score = score + node.count;
            }
            ans[i] = score;
        }
        return ans;
    }
}