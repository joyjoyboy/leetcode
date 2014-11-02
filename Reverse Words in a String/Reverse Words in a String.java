public class Solution {
    public String reverseWords(String s) {
        
        // Pre-processing
        int index = 0;
        while(index < s.length() && s.charAt(index) == ' '){
            ++index;
        }
        if(index == s.length()){
            return new String();
        }
        s = s.substring(index, s.length());
        
        index = s.length() - 1;
        while(index >= 0 && s.charAt(index) == ' '){
            --index;
        }
        if(index == -1){
            return new String();
        }
        s = s.substring(0, index + 1);
        
        String newStr = new String();
        int startIndex = -1;
        int endIndex = s.length();
        for(int i = s.length() - 1; i >= 0; --i){
            if(s.charAt(i) != ' '){
                continue;
            }
            else{
                startIndex = i + 1;
                newStr = newStr.concat(s.substring(startIndex, endIndex));
                newStr = newStr.concat(" ");
                while(s.charAt(i) == ' '){
                    --i;
                }
                endIndex = i + 1;
                ++i;
            }
        }
        startIndex = 0;
        newStr = newStr.concat(s.substring(startIndex, endIndex));
        return newStr;
    }
}
