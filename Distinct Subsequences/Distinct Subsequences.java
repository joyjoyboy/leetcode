public class Solution {
    public int numDistinct(String S, String T) {
        
        // Recursive solution works but exceeds time limit
        // I love recursion!
        // I hate DP!
        /*
        if(S.length() < T.length()){
            return 0;
        }
        
        if(T.length() == 0){
            return 1;
        }
        
        int res = 0;
        for(int i = 0; i < S.length() - T.length() + 1; ++i){
            // Starting point
            if(S.charAt(i) == T.charAt(0)){
                String newS = S.substring(i + 1);
                String newT = T.substring(1);
                res += numDistinct(newS, newT);
            }
        }
        
        return res;
        */
        
        if(S.length() < T.length()){
            return 0;
        }
        
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        for(int i = 0; i <= S.length(); ++i){
            dp[0][i] = 1;
        }
        for(int i = 0; i <= T.length(); ++i){
            for(int j = 0; j < i; ++j){
                dp[i][j] = 0;
            }
        }
        
        for(int i = 1; i <= T.length(); ++i){
            for(int j = 1; j <= S.length(); ++j){
                if(T.charAt(i - 1) == S.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
                else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[T.length()][S.length()];
    }
}
