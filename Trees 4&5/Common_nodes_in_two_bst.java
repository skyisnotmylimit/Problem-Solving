//@GFG
//Learned about inorder traversal using stack....this question helped a alot...
class IterateBST {
    Stack<Node> st = new Stack<Node>();
    IterateBST(Node root) {
        pushLeft(root);
    }
    private void pushLeft(Node root) {
        Node temp = root;
        while(temp != null) {
            st.push(temp);
            temp = temp.left;
        }
    }
    public void next() {
        Node cur = st.pop();
        pushLeft(cur.right);
    }
    public int view() {
        return st.peek().data;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
class Solution {
	public static ArrayList<Integer> findCommon(Node root1,Node root2) {
	    ArrayList<Integer> list = new ArrayList<>();
	    IterateBST t1 = new IterateBST(root1);
	    IterateBST t2 = new IterateBST(root2);
	    while(t1.hasNext() && t2.hasNext()) {
	        int v1 = t1.view();
	        int v2 = t2.view();
	        if(v1 == v2) {
	            list.add(v1);
	            t1.next();
	            t2.next();
	        }
	        else if(v1 < v2)
	        t1.next();
	        else
	        t2.next();
	    }
	    return list;
    }
}