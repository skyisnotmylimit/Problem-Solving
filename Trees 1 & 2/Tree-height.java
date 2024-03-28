//@CodeStudio
public class Solution {
    public static int heightOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        else
        return Math.max(heightOfBinaryTree(root.left),heightOfBinaryTree(root.right))+1;
    }
}
