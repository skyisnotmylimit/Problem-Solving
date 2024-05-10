//Q-639@LeetCode
class Solution {
    private static final int MOD = 1000000007;
    private int solve(String s, int pos, int[] dp) {
        if (pos == s.length()) {
            return 1;
        }
        if (dp[pos] != -1) {
            return dp[pos];
        }
        long count = 0;
        if (s.charAt(pos) == '*') {
            count = (count + 9L * solve(s, pos + 1, dp)) % MOD;
        } 
        else if (s.charAt(pos) != '0') {
            count = (count + solve(s, pos + 1, dp)) % MOD;
        }
        if (pos < s.length() - 1) {
            char first = s.charAt(pos);
            char second = s.charAt(pos + 1);
            if (first == '1') {
                if (second == '*') {
                    count = (count + 9L * solve(s, pos + 2, dp)) % MOD;
                } 
                else {
                    count = (count + solve(s, pos + 2, dp)) % MOD;
                }
            } 
            else if (first == '2') {
                if (second == '*') {
                    count = (count + 6L * solve(s, pos + 2, dp)) % MOD;
                } 
                else if (second <= '6') {
                    count = (count + solve(s, pos + 2, dp)) % MOD;
                }
            } 
            else if (first == '*') {
                if (second == '*') {
                    count = (count + 15L * solve(s, pos + 2, dp)) % MOD;
                } 
                else if (second <= '6') {
                    count = (count + 2L * solve(s, pos + 2, dp)) % MOD;
                } 
                else {
                    count = (count + solve(s, pos + 2, dp)) % MOD;
                }
            }
        }
        dp[pos] = (int) count;
        return dp[pos];
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(s, 0, dp);
    }
}
