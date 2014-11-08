public class Solution {
    
    public int minCut(String s) {
        
        int len = s.length();
        boolean[][] P = new boolean[len][len];
        
        for(int i = 0; i < len; ++i){
            for(int j = 0; j <= i; ++j){
                P[i][j] = true;
            }
        }
        
        // O(n^2) cost for computing palindrome
        for(int i = len - 1; i >= 0; --i){
            for(int j = i + 1; j < len; ++j){
                if(s.charAt(i) == s.charAt(j) && (P[i + 1][j - 1] == true)){
                    P[i][j] = true;
                }
                else{
                    P[i][j] = false;
                }
            }
        }
        
        
        int[] dp = new int[len + 1];
        // i range from -1 to len - 1
        // shift to [0, len]
        for(int i = 0; i <= len; ++i){
            dp[i] = i;
        }
        // D[i] = min(min(D[j - 1] + 1) for all possible j, D[i])
        for(int i = 0; i < len; ++i){
            for(int j = 0; j <= i; ++j){
                if(P[j][i] == true){
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                }
            }
        }
        return dp[len] - 1;
    }
}
