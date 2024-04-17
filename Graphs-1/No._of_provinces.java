//Q-547@LeetCode
class Solution {
   public void dfs(int i,boolean vis[],ArrayList<ArrayList<Integer>> adList){
        vis[i] = true;
        for(Integer it : adList.get(i)){
            if(vis[it] == false){
                dfs(it,vis,adList);
            }
        }
   }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
        int V = isConnected.length;
        for(int i=0;i<V;i++) adList.add(new ArrayList<Integer>());
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adList.get(i).add(j);
                    adList.get(j).add(i);
                }
            }
        }
        boolean vis[] = new boolean[V];
        int count = 0;
        for(int i = 0;i<V;i++){
            if(vis[i] == false){
                count++;
                dfs(i,vis,adList);
            }
        }
        return count; 
    }
}