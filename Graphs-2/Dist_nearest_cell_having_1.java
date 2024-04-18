//@GFG
class Pair {
    int x;
    int y;
    int dist;
    Pair(int x,int y,int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {
    public int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int ans[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int dist = q.peek().dist;
            q.remove();
            ans[x][y] = dist;
            for(int i=0;i<4;i++) {
                int r = x + dir[i][0];
                int c = y + dir[i][1];
                if(r >=0 && r < m && c >=0 && c < n && !vis[r][c]) {
                    vis[r][c] = true;
                    q.add(new Pair(r,c,dist+1));
                }
            }
        }
        return ans;
    }
}