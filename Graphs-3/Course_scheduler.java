//Q-207@LeetCode
class Solution {
    public boolean dfs(int node,boolean vis[],boolean path[],ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        path[node] = true;
        for(int nbour : adj.get(node)){
            if(!vis[nbour]){
                if(dfs(nbour,vis,path,adj)) return true;
            }
            else if(path[nbour]) return true;
        }
        path[node] = false;
        return false;
    }
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[n];
        boolean path[] = new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(i,vis,path,adj)) return false;
            }
        }
        return true;
    }
}