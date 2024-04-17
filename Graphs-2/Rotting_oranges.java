//Q-994@LeetCode
class Pair{
    int x;
    int y;
    int tym;
    Pair(int x,int y,int tym){
        this.x = x;
        this.y = y;
        this.tym = tym;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        int cntFresh = 0;
        int tym = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i,j,tym));
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int t = q.peek().tym;
            tym = Math.max(tym,t);
            q.remove();
            for(int dir=-1;dir<=1;dir++){
                if(dir == 0)continue;
                int newRow = x + dir;
                int newCol = y + dir;
                if((newRow >= 0 && newRow < m) && (vis[newRow][y] == 0) && (grid[newRow][y] == 1)){
                    q.add(new Pair(newRow,y,t+1));
                    vis[newRow][y] = 2;
                    cnt++;
                }
                if((newCol >= 0 && newCol < n) && (vis[x][newCol] == 0) && (grid[x][newCol] == 1)){
                    q.add(new Pair(x,newCol,t+1));
                    vis[x][newCol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return tym;
    }
}