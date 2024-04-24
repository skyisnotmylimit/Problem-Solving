//Q-3115@LeetCode
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Cmp implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        if (a.y == b.y)
            return a.x - b.x;
        return a.y - b.y;
    }
}
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] path = new int[n];
        TreeSet<Pair> pq = new TreeSet<>(new Cmp());
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            path[i] = Integer.MAX_VALUE;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        pq.add(new Pair(0, 0));
        path[0] = 0;
        while (!pq.isEmpty()) {
            Pair top = pq.pollFirst();
            int u = top.x;
            int wt = top.y;
            for (Pair temp : adj.get(u)) {
                int v = temp.x;
                int curWt = temp.y;
                int dist = curWt + wt;
                if (path[v] > dist && dist < disappear[v]) {
                    if (path[v] != Integer.MAX_VALUE) {
                        pq.remove(new Pair(v, path[v]));
                    }
                    path[v] = dist;
                    pq.add(new Pair(v, dist));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (path[i] > disappear[i]) {
                path[i] = -1;
            }
        }
        return path;
    }
}