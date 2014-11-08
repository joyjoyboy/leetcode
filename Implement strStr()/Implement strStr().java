public class Solution {
    public int strStr(String haystack, String needle) {
        if((haystack == null) || (needle == null)){
            return -1;
        }   
        else if(needle.length() == 0){ 
            return 0;
        }   
        for(int i = 0; i < haystack.length() - (needle.length() - 1); ++i){
            if(haystack.charAt(i) == needle.charAt(0)){
                boolean found = true;
                for(int j = 1; j < needle.length(); ++j){
                    if(haystack.charAt(i + j) != needle.charAt(j)){
                        found = false;
                        break;
                    }   
                }   
                if(found){
                    return i;
                }   
            }   
        }   
        return -1;
    }
}
