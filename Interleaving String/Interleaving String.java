public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

// Recursive solution
// Compact, precise but inefficient
/*
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        if(s1.length() == 0){
            return s2.equals(s3);
        }
        else if(s2.length() == 0){
            return s1.equals(s3);
        }
        else{
            String sub3 = s3.substring(1);
            if(s3.charAt(0) == s1.charAt(0)){
                String sub1 = s1.substring(1);
                if(isInterleave(sub1, s2, sub3)){
                    return true;
                }
            }
            if(s3.charAt(0) == s2.charAt(0)){
                String sub2 = s2.substring(1);
                if(isInterleave(s1, sub2, sub3)){
                    return true;
                }
            }
            return false;
        }
*/

        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        if(s1.length() == 0){
            return s2.equals(s3);
        }
        else if(s2.length() == 0){
            return s1.equals(s3);
        }
        
        // true: s1 from 0 to i plus s2 from 0 to j forms s3 from 0 to i + j
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        // Initialize
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); ++i){
            if(s1.charAt(i - 1) == s3.charAt(i - 1)){
                dp[i][0] = dp[i - 1][0];
            }
            else{
                dp[i][0] = false;
            }
        }
        for(int i = 1; i <= s2.length(); ++i){
            if(s2.charAt(i - 1) == s3.charAt(i - 1)){
                dp[0][i] = dp[0][i - 1];
            }
            else{
                dp[0][i] = false;
            }
        }
        
        for(int i = 1; i <= s1.length(); ++i){
            for(int j = 1; j <= s2.length(); ++j){
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j];
                }
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = (dp[i][j - 1]) ? true : dp[i][j];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
