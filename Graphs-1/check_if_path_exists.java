//Q-1971@LeetCode
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Integer>());
        for(int i[] : edges) {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        while(!q.isEmpty()) {
            int cur = q.remove();
            if(cur == destination) return true;
            for(int nbour : adj.get(cur)) {
                if(!vis[nbour]){
                    vis[nbour] = true;
                    q.add(nbour);
                }
            }
        }
        return false;
    }
}