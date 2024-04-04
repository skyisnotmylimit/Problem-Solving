//@GFG
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
class Solution
{
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> ans = new ArrayList<>();
        IterateBST t1 = new IterateBST(root1);
        IterateBST t2 = new IterateBST(root2);
        //Now it is similar to merging two sorted arrays....
	    while(t1.hasNext() && t2.hasNext()) {
	        int v1 = t1.view();
	        int v2 = t2.view();
	        if(v1 <= v2) {
	            ans.add(v1);
	            t1.next();
	        }
	        else{
	            ans.add(v2);
	            t2.next();
	        }
	    }
	    while(t1.hasNext()){
	        ans.add(t1.view());
	        t1.next();
	    }
	    while(t2.hasNext()){
	        ans.add(t2.view());
	        t2.next();
	    }
	    return ans;
    }
}
