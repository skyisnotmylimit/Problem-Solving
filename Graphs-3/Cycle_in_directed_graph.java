//@GFG
class Solution {
    public boolean dfs(int node,boolean vis[],boolean path[],ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        path[node] = true;
        for(int nbour : adj.get(node)){
            if(!vis[nbour]){
                if(dfs(nbour,vis,path,adj))
                return true;
            }
            else if(path[nbour]){
                return true;
            }
        }
        path[node] = false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        boolean path[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,vis,path,adj))
                return true;
            }
        }
        return false;
    }
}