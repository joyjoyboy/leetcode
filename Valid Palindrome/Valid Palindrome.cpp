class Solution {
public:
    bool isPalindrome(string s) {
        std::vector<char>   str;
        int diff = 'a' - 'A';
        for(unsigned int i = 0; i < s.size(); ++i){
            char c = s[i];
            if((c >= 'A') && (c <= 'Z')){
                c += diff;
                str.push_back(c);
            }
            else if((c >= 'a') && (c <= 'z')){
                str.push_back(c);
            }
            else if((c >= '0') && (c <= '9')){
                str.push_back(c);
            }
            else{
                // Ignore
            }
        }
        for(unsigned int i = 0; i < str.size() / 2; ++i){
            if(str[i] != str[str.size() - 1 - i])       return false;
        }
        return true;
    }
};
