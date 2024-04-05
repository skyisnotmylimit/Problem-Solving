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
    public Node next() {
        Node cur = st.pop();
        pushLeft(cur.right);
        return cur;
    }
    public int view() {
        return st.peek().data;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
class Solution { 
    Node bTreeToClist(Node root) {
        IterateBST t = new IterateBST(root);
        Node head = null;
        Node temp = null;
        while(t.hasNext()) {
            Node cur = t.next();
            cur.left = null;
            cur.right = null;
            if(head == null) {
                head = cur;
                temp = head;
            }
            else{
                temp.right = cur;
                cur.left = temp;
                temp = temp.right;
            }
        }
        temp.right = head;
        head.left = temp;
        return head;
    }
}
