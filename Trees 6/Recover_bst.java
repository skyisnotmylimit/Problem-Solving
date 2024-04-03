//Q-99@LeetCode
class Tuple{
    TreeNode last;
    TreeNode first;
    TreeNode mid;
    TreeNode prev;
    Tuple() {
        last = null;
        first = null;
        mid = null;
        prev = new TreeNode(Integer.MIN_VALUE);
    }
}
class Solution {
    public void inorder(TreeNode root,Tuple ans){
        if(root == null){
            return;
        }
        inorder(root.left,ans);
        if(root.val < ans.prev.val){
            if(ans.first == null){
                ans.first = ans.prev;
                ans.mid = root;
            }
            else{
                ans.last = root;
            }
        }
        ans.prev = root;
        inorder(root.right,ans);
    }
    public void recoverTree(TreeNode root) {
        Tuple ans = new Tuple();
        inorder(root,ans);
        if(ans.first != null && ans.last != null){
            int t = ans.first.val;
            ans.first.val = ans.last.val;
            ans.last.val = t;
        }
        else if(ans.first != null && ans.mid !=null){
            int i = ans.first.val;
            ans.first.val = ans.mid.val;
            ans.mid.val = i;
        }
    }
}
