//Q-1391@LeetCode
class Solution {
    int[][][] dir = new int[][][]{{{0,-1},{0,1}},
                                  {{1,0},{-1,0}},
                                  {{0,-1},{1,0}},
                                  {{1,0},{0,1}},
                                  {{0,-1},{-1,0}},
                                  {{-1,0},{0,1}}};
    public boolean hasValidPath(int[][] grid) {
        return dfs(0,0,grid);
    }
    private boolean dfs(int r, int c, int[][] grid){
        if(r==grid.length-1 && c==grid[r].length-1)return true;
        int num = grid[r][c];
        grid[r][c]=-1;
        int nextCoord[] = getNextCoord(r,c,num,grid);
        if(nextCoord==null)return false;
        return dfs(nextCoord[0],nextCoord[1],grid);
    }
    private int[] getNextCoord(int r, int c, int num, int[][] grid){
        for(int move[] : dir[num-1]){
            int nr=move[0]+r;
            int nc=move[1]+c;
            if(nr<0 || nc<0 || nr==grid.length || nc==grid[nr].length || grid[nr][nc]<0 || 
			  (num==1 && grid[nr][nc]==2) || (num==2 && grid[nr][nc]==1))continue;
            return new int[]{nr,nc};
        }
        return null;
    }
}