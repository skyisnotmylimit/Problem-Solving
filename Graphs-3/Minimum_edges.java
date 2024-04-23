//@GFG
class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Cmp implements Comparator<Pair> {
    public int compare(Pair a,Pair b) {
        if(a.y == b.y) return a.x - b.x;
        else return a.y - b.y;
    }
}
class Solution {
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        // code here
        int path[] = new int[n+1];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            path[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v,0));
            adj.get(v).add(new Pair(u,1));
        }
        path[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Cmp());
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()) {
            int node = pq.peek().x;
            int wt = pq.peek().y;
            pq.remove();
            for(Pair nbour : adj.get(node)) {
                int x = nbour.x;
                int y = nbour.y;
                if(path[x] > y + wt){
                    path[x] = y + wt;
                    pq.add(new Pair(x,path[x]));
                }
            }
        }
        return (path[dst] == Integer.MAX_VALUE) ? -1 : path[dst];
    }
}