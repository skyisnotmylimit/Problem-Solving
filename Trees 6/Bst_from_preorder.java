//Q-1008@LeetCode
class Solution {
    public TreeNode insert(TreeNode root,TreeNode key) {
        if(root == null) {
            root = key;
            return root;
        }
        if(key.val < root.val) root.left = insert(root.left,key);
        else root.right = insert(root.right,key);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++) {
            TreeNode key = new TreeNode(preorder[i]);
            root = insert(root,key);
        }
        return root;
    }
}
