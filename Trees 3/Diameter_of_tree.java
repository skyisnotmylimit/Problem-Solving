//Q-543@LeetCode
class Solution {
    public int height(TreeNode root,int max[]) {
        if(root == null) return 0;
        int l = height(root.left,max);
        int r = height(root.right,max);
        max[0] = Math.max(l+r,max[0]);
        return Math.max(l,r) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int d[] = new int[1];
        height(root,d);
        return d[0];
    }
}