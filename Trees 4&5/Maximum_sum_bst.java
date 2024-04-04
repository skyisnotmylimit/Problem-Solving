//Q-1373@LeetCode
class Tuple {
    int count;
    int min;
    int max;
    Tuple(int count,int min,int max) {
        this.count = count;
        this.min = min;
        this.max = max;
    }
}
class Solution {
    static final int minVal = Integer.MIN_VALUE;
    static final int maxVal = Integer.MAX_VALUE;
    public Tuple solve(TreeNode root,int MaxSum[]) {
        if(root == null) {
            return new Tuple(0,maxVal,minVal);
        }
        Tuple leftSub = solve(root.left,MaxSum);
        Tuple rightSub = solve(root.right,MaxSum);
        if(root.val > leftSub.max && root.val < rightSub.min) {
            int sum = leftSub.count + rightSub.count + root.val;
            MaxSum[0] = Math.max(MaxSum[0],sum);
            return new Tuple(sum,Math.min(root.val,leftSub.min),Math.max(root.val,rightSub.max));
        }
        else{
            return new Tuple(0,minVal,maxVal);
        }
    }
    public int maxSumBST(TreeNode root) {
        int MaxSum[] = new int[1];
        Tuple ans = solve(root,MaxSum);
        return MaxSum[0];
    }
}