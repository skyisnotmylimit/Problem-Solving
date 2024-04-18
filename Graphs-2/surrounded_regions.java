//Q-130@LeetCode
class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void bfs(char board[][],boolean vis[][],Pair cur) {
        int m = board.length;
        int n = board[0].length;
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<Pair> q = new LinkedList<>();
        q.add(cur);
        vis[cur.x][cur.y] = true;
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.remove();
            for(int i=0;i<4;i++) {
                int r = x + dir[i][0];
                int c = y + dir[i][1];
                if(r >=0 && r < m && c >=0 && c < n && !vis[r][c] && board[r][c] == 'O') {
                    vis[r][c] = true;
                    q.add(new Pair(r,c));
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for (int i = 0;i<n;i++) {
            if (board[0][i] == 'O' && !vis[0][i])
            bfs(board, vis, new Pair(0, i));
            if (board[m - 1][i] == 'O' && !vis[m - 1][i])
            bfs(board, vis, new Pair(m - 1, i));
        }
        for (int i=0;i<m;i++) {
            if (board[i][0] == 'O' && !vis[i][0])
            bfs(board, vis, new Pair(i, 0));
            if (board[i][n - 1] == 'O' && !vis[i][n - 1])
            bfs(board, vis, new Pair(i, n - 1));
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O' && !vis[i][j])
                board[i][j] = 'X';
            }
        }
    }
}