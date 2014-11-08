public class Solution {
    public int numDecodings(String s) {
        
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); ++i){
            if(i == 0){
                dp[i] = 1;
            }
            // The two characters before i form a valid combination
            else if(i >= 2 && ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6'))){
                if(s.charAt(i - 1) != '0'){
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
                else{
                    dp[i] = dp[i - 2];
                }
            }
            // Only the character before i forms a valid combination
            else if(s.charAt(i - 1) != '0'){
                dp[i] = dp[i - 1];
            }
            // Not a valid combination
            else{
                return 0;
            }
            
        }
        return dp[s.length()];
    }
}
