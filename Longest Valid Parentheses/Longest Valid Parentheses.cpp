class Solution {
public:
    int longestValidParentheses(string s) {
        std::stack<int> stk;
        int start = 0;
        int len = 0;
        for(int i = 0; i < s.length(); ++i){
            char c = s[i];
            if(c == '('){
                stk.push(i);
            }
            else{
                if(stk.empty()){
                    // Start from next element
                    start = i + 1;
                }
                else{
                    stk.pop();
                    len = std::max(len, stk.empty() ? i - start + 1 : i - stk.top());
                }
            }
        }
        return len;
    }
};
