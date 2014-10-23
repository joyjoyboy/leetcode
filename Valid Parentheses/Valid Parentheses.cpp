class Solution {
public:
    bool isValid(string s) {

        if(s.empty())       return false;
        
        std::stack<char>    left;
        for(unsigned int i = 0; i < s.size(); ++i){
            switch(s[i]){
                case '(':
                    left.push(s[i]);
                    break;
                case ')':
                    if(left.empty() || left.top() != '(')
                        return false;
                    else
                        left.pop();
                    break;
                case '[':
                    left.push(s[i]);
                    break;
                case ']':
                    if(left.empty() || left.top() != '[')  
                        return false;
                    else
                        left.pop();
                    break;
                case '{':
                    left.push(s[i]);
                    break;
                case '}':
                    if(left.empty() || left.top() != '{')
                        return false;
                    else
                        left.pop();
                    break;
                default:
                    break;
            }
        }
        if(left.empty())                    return true;
        else                                return false;
    }
};
