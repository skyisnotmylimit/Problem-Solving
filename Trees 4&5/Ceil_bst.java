//@GFG
class Tree {
    int findCeil(Node root, int key) {
        int ans = -1;
        while(root != null) {
            if(root.data == key) {
                ans = root.data;
                return ans;
            }
            else if(key > root.data) {
                root = root.right;
            }
            else {
                ans = root.data;
                root = root.left;
            }
        }
        return ans;
    }
}