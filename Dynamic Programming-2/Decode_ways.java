//Q-91@LeetCode
class Solution {
    private int solve(String s,int pos,int dp[]) {
        if(pos == s.length()) 
        return 1;
        if(s.charAt(pos) == '0')
        return 0;
        if(dp[pos] != -1) return dp[pos];
        int count = solve(s,pos+1,dp);
        if(pos < s.length()-1) {
            String temp = "";
            temp = temp + s.charAt(pos) + s.charAt(pos+1);
            int x = Integer.parseInt(temp);
            if(x < 27){
                count = count + solve(s,pos+2,dp);
            }
        }
        return dp[pos] = count;
    }
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return solve(s,0,dp);
    }
}