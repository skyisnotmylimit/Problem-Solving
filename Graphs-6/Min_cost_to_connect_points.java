//Q-1584@LeetCode
class Pair {
    int x;
    int y;
    int wt;
    Pair(int x,int y,int wt) {
        this.x = x;
        this.y = y;
        this.wt = wt;
    }
}
class Cmp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return Integer.compare(a.wt, b.wt);
    }
}
class DisjointSet {
    ArrayList<Integer> rank;
    ArrayList<Integer> parent;
    DisjointSet(int n) {
        rank = new ArrayList<Integer>();
        parent = new ArrayList<Integer>();
        for(int i=0;i<n;i++) {
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUpar(int node) {
        if(parent.get(node) == node) {
            return node;
        }
        int ulp = findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ul_u = findUpar(u);
        int ul_v = findUpar(v);
        if(ul_u == ul_v)
        return;
        if(rank.get(ul_u) < rank.get(ul_v)) {
            parent.set(ul_u,ul_v);
        }
        else if(rank.get(ul_u) > rank.get(ul_v)) {
            parent.set(ul_v,ul_u);
        }
        else {
            parent.set(ul_v,ul_u);
            int rankU = rank.get(ul_u);
            rank.set(ul_u,rankU+1);
        }
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> edges = new PriorityQueue<>(new Cmp());
        int n = points.length;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int u = i;
                int v = j;
                int wt = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Pair(u,v,wt));
            }
        }
        int ans = 0;
        while(!edges.isEmpty()) {
            int u = edges.peek().x;
            int v = edges.peek().y;
            int wt = edges.peek().wt;
            edges.remove();
            int ul_u = ds.findUpar(u);
            int ul_v = ds.findUpar(v);
            if(ul_u != ul_v) {
                ds.unionByRank(u,v);
                ans = ans + wt;
            }
        }
        return ans;
    }
}