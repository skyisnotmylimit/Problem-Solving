//Q-1334@LeetCode
class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        int dist[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i == j)
                dist[i][j] = 0;
                else
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    int x = dist[i][j];
                    int y = Integer.MAX_VALUE;
                    if(dist[i][k] != y && dist[k][j] != y)
                    y = dist[i][k] + dist[k][j];
                    dist[i][j] = Math.min(x,y);
                }
            }
        }
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=0;j<n;j++) {
                if(dist[i][j] <= t)
                count++;
            }
            if(count == min){
                ans = Math.max(i,ans);
            }
            else if(count < min) {
                min = count;
                ans = i;
            }
        }
        return ans;
    }
}