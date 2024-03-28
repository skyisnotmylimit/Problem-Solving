//Q-112@LeetCode
class Solution {
    public boolean traverse(TreeNode root,int target) {
        if(root == null) return false;
        target = target - root.val;
        if(root.left == null && root.right == null) {
            if(target == 0)
            return true;
        }
        return traverse(root.left,target) || traverse(root.right,target);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return traverse(root,targetSum);
    }
}