import java.util.*;
class TrieNode {
    TrieNode links[];
    boolean isWord;
    ArrayList<String> commonPrefix;
    TrieNode() {
        links = new TrieNode[26];
        isWord = false;
        commonPrefix = new ArrayList<String>();
    }
    public void setEnd() {
        isWord = true;
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
    public void addPrefix(String word) {
        commonPrefix.add(word);
    }
}
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dict[] = {"shubham","shubh","preet","preeti","ram","raman","ramay","ramsey","arya","arav","aryan","ayyan"};
        TrieNode root = new TrieNode();
        //Construct Trie
        for(String s : dict) {
            TrieNode node = root;
            node.addPrefix(s);
            for(char ch : s.toCharArray()) {
                if(node.get(ch) == null) {
                    node.put(new TrieNode(),ch);
                }
                node = node.get(ch);
                node.addPrefix(s);
            }
            node.setEnd();
        }
        TrieNode node = root;
        // while(true) {
        //     System.out.println("Enter a Character : ");
        //     char ch = in.next().charAt(0);
        //     if(ch < 97 && ch > 122)
        //     break;
        //     if(node.get(ch) == null) {
        //         System.out.println("No words present to suggest !!");
        //         break;
        //     }
        //     node = node.get(ch);
        //     System.out.println(node.commonPrefix);
        // }
        System.out.println(node.commonPrefix);
        in.close();
    }
}
