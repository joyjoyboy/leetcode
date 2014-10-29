public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        // Recursion exceeds time limit
        /*
        if(s.isEmpty()){
            return true;
        }
        // s.substring(0, i) forms a word potentially
        for(int i = 1; i <= s.length(); ++i){
            String word = s.substring(0, i);
            if(dict.contains(word)){
                dict.remove(word);
                if(wordBreak(s.substring(i), dict)){
                    return true;
                }
                dict.add(word);
            }
        }
        return false;
        */
        
        boolean[] dp = new boolean[s.length() + 1];
        for(int i = 0; i <= s.length(); ++i){
            dp[i] = false;
        }
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); ++i){
            for(int j = 0; j < i; ++j){
                String word = s.substring(j, i);
                // dp[j + 1] denotes whether s[0, j] can be segmented
                // dp[i + 1] is only true when there exists a combination
                // s.t. dp[j] is true && s[j, i] is a word
                // dp[0] is true (boundary condition)
                dp[i] = dp[j] && dict.contains(word);
                if(dp[i]){
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
