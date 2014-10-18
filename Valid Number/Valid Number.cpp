class Solution {
public:

    // Piece of crap
    // Rules cannot be more ambiguous



    bool isNumber(const char *s) {
        char c = (*s);
        const char* start = s;
        
        // Skip possible spaces
        while(c == ' '){
            s++;
            c = (*s);
        }
        
        // Whether there are spaces in a number
        bool hasSpace = false;
        bool isFractional = false;
        bool isExponential = false;
        bool hasNum = false;
        bool hasNumAfterExp = false;
        
        // Symbol handling
        if((c == '+') || (c == '-')){
            s++;
            c = (*s);
        }
        
        // Must start with a number or a dot
        if(((c < '0') || (c > '9')) && (c != '.')){
            return false;
        }
        
        while(c != '\0'){
            
            if(((c >= '0') && (c <= '9')) || (c == 'E') || (c == 'e') || (c == '.')){
                if(hasSpace){
                    return false;
                }
                if(c == '.'){
                    if(!isFractional){
                        isFractional = true;
                        if(isExponential){       // Fractional exponent is not allowed
                            return false;
                        }
                    }
                    else{       // Duplicate '.'s
                        return false;
                    }
                    char nextC = (*(s + 1));
                    char prevC;
                    if(s == start){
                        prevC = NULL;
                    }
                    else{
                        prevC = (*(s - 1));
                    }
                    // '.' must be followed by a number
                    if(((nextC < '0') || (nextC > '9')) && ((prevC < '0') || (prevC > '9'))){
                        return false;
                    }
                }
                else if((c == 'e') || (c == 'E')){
                    if(!isExponential){
                        isExponential = true;
                        char nextC = (*(s + 1));
                        if((nextC == '+') || (nextC == '-')){       // Skip the symbol right after 'e'
                            s++;
                        }
                    }
                    else{       // Duplicate 'e's
                        return false;
                    }
                }
                else{
                    if(!hasNum){
                        hasNum = true;
                    }
                    if(isExponential){
                        if(!hasNumAfterExp){
                            hasNumAfterExp = true;
                        }
                    }
                }
                
            }
            else if(c == ' '){      // Space handling
                if(!hasSpace){
                    hasSpace = true;
                }
            }
            else{       // Invalid character
                return false;
            }
            s++;
            c = (*s);
        }
        
        // Only contains '.'s or 'e's
        if((isFractional || isExponential) && (!hasNum)){
            return false;
        }
        
        if(isExponential && (!hasNumAfterExp)){
            return false;
        }
        
        return true;
    }
};
