//Q-399@LeetCode
class Pair {
    String x;
    double y;
    Pair(String x,double y) {
        this.x = x;
        this.y = y;
    }
}
class Cmp implements Comparator<Pair>{
    public int compare(Pair a,Pair b){
        return Double.compare(a.y, b.y);
    }
}
class Solution {
    public double dijkstra(String src,String dst,HashMap<String,ArrayList<Pair>> adj){
        TreeSet<Pair> pq = new TreeSet<>(new Cmp());
        HashMap<String,Double> path = new HashMap<>();
        for(String node : adj.keySet()) {
            path.put(node,Double.MAX_VALUE);
        }
        path.put(src,1.0);
        pq.add(new Pair(src,1.0));
        while(!pq.isEmpty()) {
            Pair cur = pq.pollFirst();
            String u = cur.x;
            double wt = cur.y;
            for(Pair nbour : adj.get(u)) {
                String v = nbour.x;
                double curWt = nbour.y;
                double dist = curWt * wt;
                if(path.get(v) > dist){
                    path.put(v,dist);
                    pq.add(new Pair(v,dist));
                }
            }
        }
        double ans = path.get(dst);
        if(ans == Double.MAX_VALUE)
        ans = -1.0;
        return ans;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,ArrayList<Pair>> adj = new HashMap<>();
        for(int i=0;i<equations.size();i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double wt = values[i];
            ArrayList<Pair> temp = adj.getOrDefault(u,new ArrayList<Pair>());
            temp.add(new Pair(v,wt));
            adj.put(u,temp);
            temp = adj.getOrDefault(v,new ArrayList<Pair>());
            temp.add(new Pair(u,(double)1/wt));
            adj.put(v,temp);
        }
        double ans[] = new double[queries.size()];
        for(int i=0;i<queries.size();i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if(adj.containsKey(u) && adj.containsKey(v)){
                ans[i] = dijkstra(u,v,adj);
            }
            else{
                ans[i] = -1;
            }
        }
        return ans;
    }
}