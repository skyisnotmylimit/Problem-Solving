//Q-200@LeetCode
public class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void bfs(Pair it,boolean vis[][],char grid[][]){
        vis[it.x][it.y] = true;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(it.x,it.y));
        while(!q.isEmpty()){
            int r = q.peek().x;
            int c = q.peek().y;
            q.remove();

            for(int delRow=-1;delRow<=1;delRow++){
                for(int delCol=-1;delCol<=1;delCol++){
                    if((delRow==-1&&delCol==-1) || (delRow==-1&&delCol==1) || (delRow==1&&delCol==-1) || (delRow==1&&delCol==1)){
                        continue;
                    }
                    int nrow = r + delRow;
                    int ncol = c + delCol;
                    if((nrow >=0 && nrow < n) && (ncol >=0 && ncol < m) 
                    && (grid[nrow][ncol] == '1') && (!vis[nrow][ncol])){
                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((!vis[i][j]) && (grid[i][j] == '1')){
                    count++;
                    bfs(new Pair(i,j),vis,grid);
                }
            }
        }
        return count;
    }
}