public class Solution {
    public boolean isMatch(String s, String p) {
        
        if(p.length() == 0){
            return s.length() == 0;
        }
        
        else if(p.length() == 1 || p.charAt(1) != '*'){
            if(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')){
                return isMatch(s.substring(1), p.substring(1));
            }
            else{
                return false;
            }
        }
        
        else{
            // Discard consecutive '*' string
            int pIndex = 2;
            while(pIndex < p.length()){
                if(p.charAt(pIndex) != '*'){
                    break;
                }
                ++pIndex;
            }
            // Match s with p
            // Always try to match s with p.substring(pIndex)
            // If p.charAt(0) matches s.charAt(0)
            // try to match every substring of s with p.substring(pIndex)
            for(int i = 0; i <= s.length() && (i == 0 || s.charAt(i - 1) == p.charAt(0) || p.charAt(0) == '.'); ++i){
                if(isMatch(s.substring(i), p.substring(pIndex))){
                    return true;
                }
            }
            return false;
        }
        
    }
}
