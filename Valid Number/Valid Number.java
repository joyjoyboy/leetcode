public class Solution {
    public boolean isNumber(String s) {
        char[] str = s.toCharArray();
        int index = 0;
        
        boolean hasDot = false;
        boolean hasE = false;
        boolean hasNum = false;
        boolean hasNumAfterDot = false;
        boolean hasNumAfterE = false;
        
        // skip possible spaces
        while(str[index] == ' '){
            ++index;
            if(index == str.length){
                return false;
            }
        }
        
        if(str[index] == '-' || str[index] == '+'){
            ++index;
            if(index == str.length || str[index] < '0' || str[index] > '9'){
                // '+.1' is valid
                // wth
                if(str[index] != '.')
                    return false;
            }
        }
        
        // '.' might be the first character of a numeric
        if(str[index] == '.'){
            ++index;
            hasDot = true;
            
            if(index == str.length || str[index] < '0' || str[index] > '9'){
                return false;
            }
        }
        
        // E.g. "01" is legitimate numeral
        // This block is commented out therefore
        /*
        if(str[index] == '0'){
            ++index;
            if(index == str.length){
                return true;
            }
            else if(str[index] != '.'){
                return false;
            }
        }
        */
        
        for(int i = index; i < str.length; ++i){
            char c = str[i];
            // Any character other than '0'~'9' and '.' and 'e' cannot appear
            if(c >= '0' && c <= '9'){
                if(hasE && !hasNumAfterE){
                    hasNumAfterE = true;
                }
                // E.g. "3." is valid
                // This block is therefore commented out
                /*
                if(hasDot && !hasNumAfterDot){
                    hasNumAfterDot = true;
                }
                */
                hasNum = true;
                continue;
            }
            
            
            else if(c == '.'){
                // wth
                // '6e6.5' is invalid
                if(hasDot || hasE)          return false;
                else                hasDot = true;
            }
            
            else if(c == 'e'){
                if(hasE || !hasNum)             return false;
                else                            hasE = true;
            }
            
            
            // A space character denotes the end of numeric, if it's a valid one
            else if(c == ' '){
                while(str[i] == ' '){
                    ++i;
                    if(i == str.length){
                        break;
                    }
                }
                if(i != str.length){
                    return false;
                }
                else{
                    break;
                }
            }
            
            else if(c == '+' || c == '-'){
                if(hasE && !hasNumAfterE){
                    // pass
                }
                else{
                    return false;
                }
            }
            
            // unexpected character
            else{
                return false;
            }
        }
        
        if(hasDot && !hasNum)       return false;
        if(hasE && !hasNumAfterE)           return false;
        
        return true;
    }
}
