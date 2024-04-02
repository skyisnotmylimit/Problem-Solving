//Q-108@LeetCode
class Solution {
    public TreeNode construct(int low,int high,int a[]) {
        if(low > high) return null;
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = construct(low,mid-1,a);
        root.right = construct(mid+1,high,a);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        int low = 0;
        int high = nums.length - 1;
        return construct(low,high,nums);
    }
}