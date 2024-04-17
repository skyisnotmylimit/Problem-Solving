//@InterviewBit
class Pair{
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    public int knight(int A, int B, int C, int D, int E, int F) {
        int dir[][] = {{2,1},{1,2},{-1,2},{2,-1},{-2,1},{-2,-1},{1,-2},{-1,-2}};
        boolean vis[][] = new boolean[A][B];
        Queue<Pair> q = new LinkedList<>();
        int lvl = 0;
        q.add(new Pair(C-1,D-1));
        vis[C-1][D-1] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Pair cur = q.remove();
                if(cur.x == E-1 && cur.y == F-1)
                return lvl;
                for(int j=0;j<8;j++) {
                    int row = cur.x + dir[j][0];
                    int col = cur.y + dir[j][1];
                    if(row >= 0 && row < A && col >= 0 && col < B && !vis[row][col]){
                        vis[row][col] = true;
                        q.add(new Pair(row,col));
                    }
                }
            }
            lvl++;
        }
        return -1;
    }
}
