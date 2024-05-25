//Q-72@LeetCode
class Solution {
    private int solve(String w1,String w2,int i,int j) {
        if(i == 0 && j == 0) return 0;
        if(i == 0)
        return j+1;
        if(j == 0)
        return i+1;
        if(w1.charAt(i-1) == w2.charAt(j-1))
        return solve(w1,w2,i-1,j-1);
        else {
            int step1 = 1 + solve(w1,w2,i,j-1);
            int step2 = 1 + solve(w1,w2,i-1,j);
            int step3 = 1 + solve(w1,w2,i-1,j-1);
            int min = Math.min(step1,step2);
            min = Math.min(min,step3);
            return min;
        }
    }
    public int minDistance(String word1, String word2) {
        int i = word1.length();
        int j = word2.length();
        return solve(word1,word2,i,j);
    }
}

class Solution {
    private int solve(String w1,String w2,int i,int j,int dp[][]) {
        if(i == 0)
        return j;
        if(j == 0)
        return i;
        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i-1) == w2.charAt(j-1))
        return dp[i][j] = solve(w1,w2,i-1,j-1,dp);
        int step1 = 1 + solve(w1,w2,i,j-1,dp);
        int step2 = 1 + solve(w1,w2,i-1,j,dp);
        int step3 = 1 + solve(w1,w2,i-1,j-1,dp);
        int min = Math.min(step1,Math.min(step2,step3));
        return dp[i][j] = min;
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++) {
                dp[i][j] = -1;
            }
        }
        return solve(word1,word2,m,n,dp);
    }
}
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<=n;j++) {
            dp[0][j] = j;
        }
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int step1 = 1 + dp[i][j-1];
                    int step2 = 1 + dp[i-1][j];
                    int step3 = 1 + dp[i-1][j-1];
                    int min = Math.min(step1,Math.min(step2,step3));
                    dp[i][j] = min;
                }
            }
        }
        return dp[m][n];
    }
}