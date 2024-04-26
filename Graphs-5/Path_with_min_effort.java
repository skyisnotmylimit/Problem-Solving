//Q-1631@LeetCode
class Pair{
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public static final int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean bfs(int grid[][],int mid) {
        int m = grid.length;
        int n = grid[0].length;        
        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        q.add(new Pair(0,0));
        vis[0][0] = true;
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.remove();
            if(x == m-1 && y == n-1) return true;
            for(int i=0;i<4;i++) {
                int r = x + dir[i][0];
                int c = y + dir[i][1];
                if(r >= 0 && r < m && c >= 0 && c < n && !vis[r][c]) {
                    int diff = Math.abs(grid[x][y] - grid[r][c]); 
                    if(diff <= mid) {
                        vis[r][c] = true;
                        q.add(new Pair(r,c));
                    }
                }
            }
        }
        return false;
    }
    public int minimumEffortPath(int[][] grid) {
        int low = 0;
        int high = (int)1e9;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(bfs(grid,mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}