public class Solution {
    public boolean isScramble(String s1, String s2) {
        
        /*
        
        // Strings w/ different lengths are not comparable
        if(s1.length() != s2.length()){
            return false;
        }
        
        // Compare the single character
        if(s1.length() == 1){
            return s1.equals(s2);
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        String s1_sorted = String.valueOf(c1);
        String s2_sorted = String.valueOf(c2);
        
        if(!s1_sorted.equals(s2_sorted)){
            return false;
        }
        
        for(int i = 1; i < s1.length(); ++i){
            String s1_sub1 = s1.substring(0, i);
            String s1_sub2 = s1.substring(i, s1.length());
            String s2_sub1 = s2.substring(0, i);
            String s2_sub2 = s2.substring(i, s2.length());
            String s2_sub3 = s2.substring(0, s2.length() - i);
            String s2_sub4 = s2.substring(s2.length() - i, s2.length());
            
            if(isScramble(s1_sub1, s2_sub1) && isScramble(s1_sub2, s2_sub2)){
                return true;
            }
            
            if(isScramble(s1_sub1, s2_sub4) && isScramble(s1_sub2, s2_sub3)){
                return true;
            }
        }
        
        return false;
        
        */
        
        if(s1.length() != s2.length()){
            return false;
        }
        else if(s1.length() == 0){
            return true;
        }
        else if(s1.length() == 1){
            return s1.equals(s2);
        }
        
        int n = s1.length();
        
        // dp[i][j][k] : s1.substr(i, i + k) and s2.substr(j, j + k) are scramble strs
        // dp[i][j][k] is true if dp[i][j][p] && dp[i + p][j + p][q] || dp[i][j + q][p] && dp[i + p][j][q], where p + q == k
        boolean[][][] dp = new boolean[n][n][n + 1];
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                for(int k = 0; k <= n; ++k){
                    if(i + k > n || j + k > n){
                        dp[i][j][k] = false;
                    }
                    else{
                        if(k == 1){
                            if(s1.charAt(i) == s2.charAt(j)){
                                dp[i][j][k] = true;
                            }
                            else{
                                dp[i][j][k] = false;
                            }
                        }
                    }
                }
            }
        }
        
        for(int k = 1; k <= n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    for(int p = 1; p < k; ++p){
                        int q = k - p;
                        if(i + p >= n || i + q >= n || j + p >= n || j + q >= n){
                            dp[i][j][k] = false;
                            continue;
                        }
                        
                        if((dp[i][j][p] && dp[i + p][j + p][q]) || (dp[i][j + q][p] && dp[i + p][j][q])){
                            dp[i][j][k] = true;
                            break;
                        }
                        else{
                            dp[i][j][k] = false;
                        }
                    }
                }
            }
        }
        
        return dp[0][0][n];
        
    }
}
