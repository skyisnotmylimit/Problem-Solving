//Q-2192@LeetCode
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());   
            res.add(new ArrayList<>());   
        }
        for(int[] e:edges)
            adj.get(e[0]).add(e[1]);
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            boolean[] vis=new boolean[n];
            q.add(i);
            while(!q.isEmpty()){
                int temp=q.remove();
                
                for(int e:adj.get(temp)){
                    if(!vis[e]){
                        q.add(e);
                        res.get(e).add(i);
                        vis[e]=true;
                    }
                }
            }
        }
        return res;
    }
}