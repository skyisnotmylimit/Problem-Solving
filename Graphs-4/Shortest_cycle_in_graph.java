//Q-2608@LeetCode
class Solution {
    public int bfs(int src, ArrayList<ArrayList<Integer>> adj, int n){
        int[] vis = new int[n];
        int[] par = new int[n];
        for(int i=0;i<n;i++) {
            vis[i] = -1;
            par[i] = -1;
        }
        vis[src] = 0;
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        int len = (int) 1e9;
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int nbour : adj.get(curr)) {
                if(vis[nbour] == -1){
                    vis[nbour] = vis[curr] + 1;
                    par[nbour] = curr;
                    q.add(nbour);
                } 
                else if(par[curr] != nbour && par[nbour] != curr){
                    len = Math.min(len, vis[nbour] + vis[curr] + 1);
                }
            }
        }
        return len;
    }
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) 
        adj.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int len = (int) 1e9;
        for(int i=0; i<n; i++){
            len = Math.min(len, bfs(i, adj, n));
            
        }
        if(len == (int) 1e9) return -1;
        return len;
    }
}