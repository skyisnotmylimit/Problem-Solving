//Q-210@LeetCode
class Solution {
    public boolean dfs(int node,boolean vis[],boolean path[],ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node] = true;
        path[node] = true;
        for(int nbour : adj.get(node)){
            if(!vis[nbour]){
                if(dfs(nbour,vis,path,adj,st)) return true;
            }
            else if(path[nbour]) return true;
        }
        st.push(node);
        path[node] = false;
        return false;
    }
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[n];
        boolean path[] = new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(i,vis,path,adj,st)){
                    int a[] = {};
                    return a;
                }
            }
        }
        int ans[] = new int[n];
        int k = 0;
        while(!st.isEmpty()){
            ans[k++] = st.pop();
        }
        return ans;
    }
}