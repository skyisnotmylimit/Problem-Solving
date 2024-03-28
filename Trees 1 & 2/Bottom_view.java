//@GFG
class Pair {
    int hor;
    Node node;
    Pair(Node node,int x){
        this.node = node;
        this.hor = x;
    }
}
class Solution {
    static ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            map.put(cur.hor,cur.node.data);
            if(cur.node.left != null){
                q.add(new Pair(cur.node.left,cur.hor - 1));
            }
            if(cur.node.right != null){
                q.add(new Pair(cur.node.right,cur.hor + 1));
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            temp.add(e.getValue());
        }
        return temp;
    }
}
