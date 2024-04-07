//Q-208@LeetCode
class TrieNode {
    TrieNode links[];
    boolean isWord;
    TrieNode(){
        links = new TrieNode[26];
        isWord = false;
    }
    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    public void put(TrieNode node,char ch) {
        links[ch - 'a'] = node;
    }
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    public void setEnd() {
        isWord = true;
    }
    public boolean isEnd() {
        return isWord;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(new TrieNode(),ch);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }
    public boolean startsWith(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}