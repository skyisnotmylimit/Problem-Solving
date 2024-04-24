//Q-743@LeetCode
class Pair {
    int x;
    int y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Cmp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        if(a.y == b.y)
            return a.x - b.x;
        else
            return a.y - b.y;
    }
}
class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        TreeSet<Pair> pq = new TreeSet<>(new Cmp());
        int path[] = new int[n + 1];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
            path[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v, edges[i][2]));
        }
        pq.add(new Pair(k, 0));
        path[k] = 0;
        while(!pq.isEmpty()) {
            Pair cur = pq.pollFirst();
            int u = cur.x;
            int tot = cur.y;
            for (Pair temp : adj.get(u)) {
                int v = temp.x;
                int wt = temp.y;
                int dist = tot + wt;
                if (path[v] > dist) {
                    pq.remove(new Pair(v, path[v]));
                    path[v] = dist;
                    pq.add(new Pair(v, dist));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++)
        max = Math.max(max, path[i]);
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
