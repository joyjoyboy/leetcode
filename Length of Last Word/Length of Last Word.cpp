class Solution {
public:
    int lengthOfLastWord(const char *s) {
        if(!s || ((*s) == '\0'))  return 0;
        
        int len = 0;
        int prev = 0;
        while(s && ((*s) != '\0')){
            if((*s) != ' '){
                ++len;
                ++s;
            }
            else{
                prev = len;
                len = 0;
                while((*s) == ' ')
                    ++s;
            }
        }
        
        return (len) ? len : prev;
    }
};
