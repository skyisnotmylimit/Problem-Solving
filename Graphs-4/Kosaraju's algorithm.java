//@GFG
class Solution {
    public void reverseList(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> rev,boolean vis[]) {
        for(int i=0;i<adj.size();i++) {
            vis[i] = false;
            for(int j : adj.get(i)) {
                rev.get(j).add(i);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++) {
            rev.add(new ArrayList<Integer>());
            if(!vis[i])
            dfs(adj,vis,i,st);
        }
        reverseList(adj,rev,vis);
        int ans = 0;
        while(!st.isEmpty()) {
            int node = st.pop();
            if(!vis[node]) {
                ans++;
                dfs(rev,vis,node);
            }
        }
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int node,Stack<Integer> st) {
        vis[node] = true;
        for(int nbour : adj.get(node)) {
            if(!vis[nbour])
            dfs(adj,vis,nbour,st);
        }
        st.push(node);
    }
    public void dfs(ArrayList<ArrayList<Integer>> rev,boolean vis[],int node) {
        vis[node] = true;
        for(int nbour : rev.get(node)) {
            if(!vis[nbour])
            dfs(rev,vis,nbour);
        }
    }
}
