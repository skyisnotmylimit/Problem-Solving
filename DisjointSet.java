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