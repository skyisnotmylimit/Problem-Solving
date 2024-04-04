class Solution {
    public boolean checkBSTOneChild(Node root) {
        if (root == null) 
        return true;
        if (root.left == null && root.right == null)
        return true;
        if (checkBSTOneChild(root.left) && checkBSTOneChild(root.right))
        return true;
        return false;
    }
}