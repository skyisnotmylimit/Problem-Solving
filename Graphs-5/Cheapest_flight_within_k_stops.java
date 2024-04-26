//Q-787@LeetCode
class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Node {
    int x;
    int y;
    int lvl;
    Node(int x,int y,int lvl) {
        this.x = x;
        this.y = y;
        this.lvl = lvl;
    }
}
class Cmp implements Comparator<Node>{
    public int compare(Node a,Node b){
        if(a.lvl == b.lvl){
            if(a.y == b.y)
            return a.x - b.x;
            return a.y - b.y;
        }
        else
        return a.lvl - b.lvl;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        TreeSet<Node> pq = new TreeSet<>(new Cmp());
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int path[] = new int[n];
        int level[] = new int[n];
        for(int i=0;i<n;i++) {
            path[i] = Integer.MAX_VALUE;
            level[i] = n+1;
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<flights.length;i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        pq.add(new Node(src,0,-1));
        path[src] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.pollFirst();
            int u = cur.x;
            int wt = cur.y;
            int lvl = cur.lvl;
            if(lvl <= k) {
                for(Pair nbour : adj.get(u)) {
                    int v = nbour.x;
                    int curWt = nbour.y;
                    int dist = wt + curWt;
                    int newLvl = lvl+1;
                    if(path[v] > dist && newLvl <= k) {
                        path[v] = dist;
                        pq.add(new Node(v,dist,newLvl));
                    }
                } 
            }
        }
        int ans = path[dst];
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}