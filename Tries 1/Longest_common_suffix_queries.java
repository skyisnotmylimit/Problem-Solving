//Q-3093@LeetCode
class Pair implements Comparable<Pair> {
    String word;
    int indx;
    Pair(String word, int indx) {
        this.word = word;
        this.indx = indx;
    }
    @Override
    public int compareTo(Pair other) {
        if (this.word.length() == other.word.length()) {
            return this.indx - other.indx;
        }
        return this.word.length() - other.word.length();
    }
}
class TrieNode {
    TrieNode links[];
    boolean isWord;
    PriorityQueue<Pair> commonPrefix;
    TrieNode() {
        links = new TrieNode[26];
        isWord = false;
        commonPrefix = new PriorityQueue<Pair>();
    }
    public void setEnd() {
        isWord = true;
    }
    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }
    public boolean isEnd() {
        return isWord;
    }
    public void put(TrieNode node,char ch) {
        links[ch - 'a'] = node;
    }
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    public void addPrefix(Pair p) {
        commonPrefix.add(p);
    }
}
class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        for(int i=wordsContainer.length-1;i>=0;i--) {
            TrieNode node = root;
            String s = wordsContainer[i];
            node.addPrefix(new Pair(s,i));
            for(int j=s.length()-1;j>=0;j--) {
                char ch = s.charAt(j);
                if(!node.containsKey(ch)) {
                    node.put(new TrieNode(),ch);
                }
                node = node.get(ch);
                node.addPrefix(new Pair(s,i));
            }
            node.setEnd();
        }
        int ans[] = new int[wordsQuery.length];
        for(int i = 0; i < wordsQuery.length; i++) {
            TrieNode node = root;
            String word = wordsQuery[i];
            for(int j = word.length() - 1; j >= 0; j--) {
                char ch = word.charAt(j);
                if(node.containsKey(ch)){
                    node = node.get(ch);
                }
                else {
                    break;
                }
            }
            ans[i] = node.commonPrefix.peek().indx;
        }
        return ans;
    }
}