//Q-2140@LeetCode
class Solution {
    public long solve(int quest[][],int n,long dp[]){
        if(n >= quest.length) return 0;
        if(dp[n] != -1) return dp[n];
        int point = quest[n][0];
        int skip = quest[n][1];
        long take = point + solve(quest,n+skip+1,dp);
        long ntake = 0 + solve(quest,n+1,dp);
        return dp[n] = (long)Math.max(take,ntake);
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[] = new long[n];
        Arrays.fill(dp,-1);
        return solve(questions,0,dp);
    }
    
    public long mostPoints(int [][]questions) {
        int n = questions.length;
        long dp[] = new long[n];
        dp[n-1] = questions[n-1][0];
        for(int i=n-2;i>=0;i--) {
            int skip_indx = i + questions[i][1] + 1;
            long skip = 0;
            if(skip_indx < dp.length)
            skip = dp[skip_indx];
            else skip = 0;
            dp[i] = Math.max(dp[i+1],questions[i][0] + skip);
        }
        return dp[0];
    }
}