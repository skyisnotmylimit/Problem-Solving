//Q-653@LeetCode
class Solution {
    public boolean solve(TreeNode root,HashSet<Integer> set,int k) {
        if(root == null) return false;
        if(set.contains(root.val)) return true;
        set.add(k - root.val);
        return solve(root.left,set,k) || solve(root.right,set,k);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return solve(root,set,k);
    }
}
