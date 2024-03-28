//Q-987@LeetCode
class Pair {
    int hor;
    int ver;
    TreeNode node;
    Pair(TreeNode node,int x,int y){
        this.node = node;
        this.hor = x;
        this.ver = y;
    }
}
class Cmp implements Comparator<Pair>{
    public int compare(Pair a,Pair b) {
        if(a.ver == b.ver)
        return a.node.val - b.node.val;
        return a.ver - b.ver;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Cmp cmp = new Cmp();
        TreeMap<Integer,PriorityQueue<Pair>> map = new TreeMap<Integer,PriorityQueue<Pair>>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            PriorityQueue<Pair> present = map.getOrDefault(cur.hor,new PriorityQueue<Pair>(cmp));
            present.add(cur);
            map.put(cur.hor,present);
            if(cur.node.left != null){
                q.add(new Pair(cur.node.left,cur.hor - 1,cur.ver + 1));
            }
            if(cur.node.right != null){
                q.add(new Pair(cur.node.right,cur.hor + 1,cur.ver + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Map.Entry<Integer,PriorityQueue<Pair>> e : map.entrySet()){
            PriorityQueue<Pair> pq = e.getValue();
            List<Integer> temp = new ArrayList<>();
            while(!pq.isEmpty()) {
                Pair p = pq.remove();
                temp.add(p.node.val);
            }
            ans.add(temp);
        }
        return ans;
    }
}