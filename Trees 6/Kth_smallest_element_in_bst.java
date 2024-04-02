//Q-230@LeetCode
class Solution {
    public int isFound(TreeNode root,int k[]) {
        if(root == null) return -1;
        int l = isFound(root.left,k);
        if(l != -1) return l;
        if(k[0] > 0){
            k[0] = k[0] - 1;
            if(k[0] == 0) {
                return root.val;
            }
        }
        int r = isFound(root.right,k);
        if(r != -1) return r;
        return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        int d[] = new int[1];
        d[0] = k;
        return isFound(root,d);
    }
}