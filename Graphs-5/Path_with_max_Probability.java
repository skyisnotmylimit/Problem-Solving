//Q-1514@LeetCode
class Pair {
    int x;
    double y;
    Pair(int x,double y) {
        this.x = x;
        this.y = y;
    }
}
class Cmp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        if (a.y == b.y)
        return a.x - b.x; 
        return Double.compare(b.y, a.y);
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        TreeSet<Pair> pq = new TreeSet<Pair>(new Cmp());
        double path[] = new double[n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
            path[i] = 0;
        }
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v,succProb[i]));
            adj.get(v).add(new Pair(u,succProb[i]));
        }
        pq.add(new Pair(start_node,1));
        path[start_node] = 1;
        while(!pq.isEmpty()) {
            Pair cur = pq.pollFirst();
            int u = cur.x;
            double prob = cur.y;
            for (Pair temp : adj.get(u)) {
                int v = temp.x;
                double wt = temp.y;
                double newProb = prob * wt;
                if (path[v] < newProb) {
                    pq.remove(new Pair(v, path[v]));
                    path[v] = newProb;
                    pq.add(new Pair(v, newProb));
                }
            }

        }
        return path[end_node];
    }
}