//Q-938@LeetCode
class Solution {
    public void traverse(TreeNode root,int low,int high,int sum[]) {
        if(root == null) return;
        if(root.val >= low && root.val <= high){
            sum[0] = sum[0] + root.val;
            traverse(root.left,low,high,sum);
            traverse(root.right,low,high,sum);
        }
        else if(root.val < low){
            traverse(root.right,low,high,sum);
        }
        else{
            traverse(root.left,low,high,sum);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum[] = new int[1];
        traverse(root,low,high,sum);
        return sum[0];
    }
}
