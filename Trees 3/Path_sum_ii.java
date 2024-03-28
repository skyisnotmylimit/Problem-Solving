//Q-113@LeetCode
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if(root == null)
            return ans;
            pathSum(root, 0, targetSum, new ArrayList<>());
            return ans;
        }
    public void pathSum(TreeNode root, int currSum, int targetSum, List<Integer> currList){
        if(root == null){
            return;
        }
        currList.add(root.val);
        if(root.left == null && root.right == null && currSum + root.val == targetSum){
            ans.add(new ArrayList<>(currList));
        }
        else{
            pathSum(root.left, currSum + root.val, targetSum, currList);
            pathSum(root.right, currSum + root.val, targetSum, currList);
        }
        currList.remove(currList.size() - 1);
    }
}