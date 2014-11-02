public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int dp[][] = new int[len1 + 1][len2 + 1];
        
        // Boundary condition
        for(int i = 0; i <= len1; ++i){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; ++j){
            dp[0][j] = j;
        }
        
        for(int i = 0; i < len1; ++i){
            char c1 = word1.charAt(i);
            for(int j = 0; j < len2; ++j){
                char c2 = word2.charAt(j);
                
                // If equal, the distance is not going to increase
                if(c1 == c2){
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else{
                    int insert = dp[i + 1][j] + 1;
                    int delete = dp[i][j + 1] + 1;
                    int replace = dp[i][j] + 1;
                    
                    dp[i + 1][j + 1] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        
        return dp[len1][len2];
    }
}
