//Q-785@LeetCode
class Solution {
    public boolean bfs(int[][] graph,int color[],int init) {
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(init);
        color[init] = 1;
        while(!q.isEmpty()){
            int x = q.remove();
            int curCol = color[x];
            int nbour[] = graph[x];
            for(int i : nbour){
                if(color[i] == 0){
                    q.add(i);
                    if(curCol == 2)
                    color[i] = 1;
                    else color[i] = 2;
                }
                else{
                    if(curCol == color[i]) return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for(int i=0;i<n;i++){
            if(color[i] == 0){
                boolean check = bfs(graph,color,i);
                if(!check) return false;
            }
        }
        return true;
    }
}