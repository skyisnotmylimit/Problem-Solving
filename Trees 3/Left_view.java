//@CodeStudio
import java.util.*;
public class Solution {
    public static void traverse(TreeNode<Integer> root,Integer lvl,ArrayList<Integer> ans) {
        if(root == null) return;
        if(lvl == ans.size()) 
        ans.add(root.data);
        traverse(root.left,lvl+1,ans);
        traverse(root.right,lvl+1,ans);
    }
    public static void printLeftView(TreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Integer lvl = 0;
        traverse(root,lvl,ans);
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
    }
}