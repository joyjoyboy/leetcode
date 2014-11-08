class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if(s1.size() + s2.size() != s3.size())      return false;
        else if(s1.size() == 0)                     return s2.compare(s3) == 0;
        else if(s2.size() == 0)                     return s1.compare(s3) == 0;
        
        bool** dp = new bool*[s1.size() + 1];
        for(int i = 0; i <= s1.size(); ++i){
            dp[i] = new bool[s2.size() + 1];
        }
        
        dp[0][0] = true;
        for(int i = 1; i <= s1.size(); ++i){
            dp[i][0] = (s1[i - 1] == s3[i - 1]) && dp[i - 1][0];
        }
        for(int i = 1; i <= s2.size(); ++i){
            dp[0][i] = (s2[i - 1] == s3[i - 1]) && dp[0][i - 1];
        }
        
        for(int i = 1; i <= s1.size(); ++i){
            for(int j = 1; j <= s2.size(); ++j){
                dp[i][j] = false;
                if(s1[i - 1] == s3[i + j - 1]){
                    dp[i][j] = dp[i - 1][j];
                }
                if(s2[j - 1] == s3[i + j - 1]){
                    dp[i][j] = dp[i][j - 1] || dp[i][j];
                }
            }
        }
        
        return dp[s1.size()][s2.size()];
    }
};
