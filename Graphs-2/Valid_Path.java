//@InterviewBit
class Pair {
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    int[] dx = {0,0,1,-1,1,1,-1,-1};
    int[] dy = {1,-1,0,0,1,-1,-1,1};
    public String solve(int x, int y, int n, int r, int[] X, int[] Y) {
        return bfs(x,y,X,Y,r) ? "YES" : "NO";
    }
    private boolean bfs(int fx,int fy,int[] X,int[] Y,int r){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        boolean[][] vis = new boolean[fx+1][fy+1];
        vis[0][0] = true;
        while(!q.isEmpty()){
            Pair cur = q.remove();
            int x = cur.x;
            int y = cur.y;
            if(x==fx && y==fy){
                return true;
            }
            for(int k=0;k<8;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && nx<=fx && ny>=0 && ny<=fy && !vis[nx][ny] && !isInsideCircle(nx,ny,X,Y,r)){
                    vis[nx][ny] = true;
                    q.add(new Pair(nx,ny));
                }
            }
        }
        return false;
    }
    private boolean isInsideCircle(int x,int y,int[] X,int[] Y,int r){
        for(int i=0;i<X.length;i++){
            int dist = (x-X[i])*(x-X[i]) + (y-Y[i])*(y-Y[i]);
            if(dist<=r*r){
                return true;
            }
        }
        return false;
    }
}

