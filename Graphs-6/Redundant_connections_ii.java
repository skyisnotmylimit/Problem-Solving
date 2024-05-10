//Q-658@LeetCode
class DisjointSet {
    int parent[];
    int rank[];
    public DisjointSet(int nodes) {
        parent = new int[nodes + 1];
        rank = new int[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    public boolean unionNodes(int u, int v) {
        int p1 = find(u);
        int p2 = find(v);
        if (p1 == p2)
        return false;
        if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } 
        else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodes = edges.length;
        DisjointSet dsu = new DisjointSet(nodes);
        int[] indegree = new int[nodes + 1];
        int discardEdgeIndex1 = -1, discardEdgeIndex2 = -1;
        for (int i = 0; i < nodes; i++) {
            int[] edge = edges[i];
            int u = edge[0], v = edge[1];
            if (indegree[v] == 0) {
                indegree[v] = i + 1;
            } 
            else {
                discardEdgeIndex1 = i;
                discardEdgeIndex2 = indegree[v] - 1;
            }
        }
        for (int i = 0; i < nodes; i++) {
            if (i == discardEdgeIndex1)
            continue;
            int edge[] = edges[i];
            int u = edge[0], v = edge[1];
            if (!dsu.unionNodes(u, v)) {
                if (discardEdgeIndex1 == -1) {
                    return edge;
                } 
                else {
                    return edges[discardEdgeIndex2];
                }
            }
        }
        return edges[discardEdgeIndex1];
    }
}
