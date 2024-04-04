//@GFG
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
    static Tuple solve(Node root) {
        if(root == null) {
            return new Tuple(0,maxVal,minVal);
        }
        Tuple leftSub = solve(root.left);
        Tuple rightSub = solve(root.right);
        if(root.data > leftSub.max && root.data < rightSub.min) {
            return new Tuple(leftSub.count + rightSub.count + 1,Math.min(root.data,leftSub.min),Math.max(root.data,rightSub.max));
        }
        else{
            return new Tuple(Math.max(leftSub.count,rightSub.count),minVal,maxVal);
        }
    }
    static int largestBst(Node root) {
        Tuple ans = solve(root);
        return ans.count;
    }
}