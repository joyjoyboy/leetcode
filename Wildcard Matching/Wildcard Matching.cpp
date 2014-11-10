class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        if(s == NULL || p == NULL){
            return false;
        }
        
        bool star = false;
        const char* p_prev = NULL;
        const char* s_prev = NULL;
        while((*s) != '\0'){
            char P = (*p);
            char S = (*s);
            
            if(P == '?' || S == P){
                ++s;
                ++p;
            }
            else if(P == '*'){
                star = true;
                do{
                    ++p;
                    P = (*p);
                }while(P == '*');
                // '*' is the last character and it matches with everything in s
                if(P == '\0'){
                    return true;
                }
                p_prev = p;
                s_prev = s;
            }
            else{
                if(S != P){
                    // No '*' to accomodate different characters
                    if(star == false){
                        return false;
                    }
                    // Current s cannot match with p
                    // p is rolled back to p_prev and s is also rolled back
                    p = p_prev;
                    ++s_prev;
                    s = s_prev;
                }
            }
        }
        while((*p) == '*'){
            ++p;
        }
        
        if((*p) != '\0'){
            return false;
        }
        else{
            return true;
        }
    }
};
