//Q-173@LeetCode
//Learned Inorder traversal using stack
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<TreeNode>();
        pushLeft(root);
    }
    private void pushLeft(TreeNode root) {
        TreeNode temp = root;
        while(temp != null) {
            st.push(temp);
            temp = temp.left;
        }
    }
    public int next() {
        TreeNode cur = st.pop();
        pushLeft(cur.right);
        return cur.val;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
}