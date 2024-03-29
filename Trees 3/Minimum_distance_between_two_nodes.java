//@GFG

// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
   class GfG {
    Node lca(Node root, int a, int b){
            if(root == null || root.data == a || root.data == b){
                return root;
            }
            Node left = lca(root.left,a,b);
            Node right = lca(root.right,a,b);
            if(left == null){
                return right;
            }
            else if(right == null){
                return left;
            }
            else return root;
        }
    int distanceFromNode(Node root,int a){
        if(root == null){
            return -1;
        }
        if(root.data == a){
            return 0;
        }
        int left = distanceFromNode(root.left, a);
        int right = distanceFromNode(root.right, a);
        if(left != -1){
            return 1 + left;
        }
        if(right != -1){
            return 1+right;
        }
        return -1;
    }
    int findDist(Node root, int a, int b) {
       if(root==null){
           return -1;
       }
       Node leastan = lca(root,a,b);
       int x = distanceFromNode(leastan,a);
       int y = distanceFromNode(leastan,b);
       return x + y;
       
    }
}
