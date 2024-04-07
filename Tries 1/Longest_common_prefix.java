//Q-14@LeetCode
class TrieNode {
    TrieNode links[];
    boolean isWord;
    int count;
    TrieNode() {
        links = new TrieNode[26];
        isWord = false;
        count = 0;
    }
    public void setEnd() {
        isWord = true;
    }
    public boolean isEnd() {
        return isWord;
    }
    public void put(TrieNode node,char ch) {
        if (links[ch - 'a'] == null) {
            links[ch - 'a'] = node;
            count++;
        }
    }
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    public int getCount() {
        return count;
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        for(String s : strs) {
            TrieNode node = root;
            for(int i=0;i<s.length();i++) {
                char ch = s.charAt(i);
                if(!node.containsKey(ch)) {
                    node.put(new TrieNode(),ch);
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
        String ans = "";
        TrieNode node = root;
        for(char ch : strs[0].toCharArray()) {
            if(node.getCount() == 1 && !node.isEnd()) {
                ans = ans + ch;
                node = node.get(ch);
            }
            else{
                break;
            }
        }
        return ans;
    }
}
