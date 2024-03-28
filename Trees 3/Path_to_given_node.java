//@interviewBit
public class Solution {
    public boolean pathFound(TreeNode root,ArrayList<Integer> path,int target) {
        if(root == null) return false;
        if(target == root.val)
        return true;
        boolean left = pathFound(root.left,path,target);
        boolean right = pathFound(root.right,path,target);
        if(left)
        path.add(0,root.left.val);
        if(right)
        path.add(0,root.right.val);
        return left || right;
    }
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> path = new ArrayList<>();
        pathFound(A,path,B);
        int ans[] = new int[path.size()+1];
        ans[0] = A.val;
        for(int i=1;i<=path.size();i++){
            ans[i] = path.get(i-1);
        }
        return ans;
    }
}
