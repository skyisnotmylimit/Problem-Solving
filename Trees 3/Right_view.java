//Q-199@LeetCode
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void traverse(TreeNode root,int lvl,List<Integer> ans) {
        if(root == null) return;
        if(lvl == ans.size()) 
        ans.add(root.val);
        traverse(root.right,lvl+1,ans);
        traverse(root.left,lvl+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root,0,ans);
        return ans;        
    }
}