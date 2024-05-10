//Q-1579@LeetCode
class DisjointSet{
    int n;
    int par[];
    int rank[];
    public DisjointSet(int n){
        this.n = n;
        par = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            par[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]);
    }
    public int union(int a, int b){
        int parA = find(a);
        int parB = find(b);
        if(parA == parB){
            return 0;
        }
        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
        n--;
        return 1;
    }
    public boolean isConnected(){
        return n == 1;
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet Alice = new DisjointSet(n);
        DisjointSet Bob = new DisjointSet(n);
        int edgesReq = 0;
        for(int edge[]: edges){
            if(edge[0] == 3){
                edgesReq += (Alice.union(edge[1], edge[2]) | Bob.union(edge[1], edge[2]));
            }
        }
        for(int edge[]: edges){
            if(edge[0] == 1){
                edgesReq += Alice.union(edge[1], edge[2]);
                
            }else if(edge[0] == 2){
                edgesReq += Bob.union(edge[1], edge[2]);
            }
        }
        if(Alice.isConnected() && Bob.isConnected()){
            return edges.length - edgesReq;
        }
        return -1;
    }
}