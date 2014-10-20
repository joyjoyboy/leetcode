class Solution {
public:

    vector<string> generateParenthesis(int n) {
        
        
        
        std::vector<std::string>    res;
        if(!n)                      return res;
        
        // 1 stands for left parentheses
        // 0 stands for right parentheses
        int num = 0;
        // There cannot be more '0's before '1's
        while(num < (1 << (2 * n))){
            
            if(!(num & 1) && (num & (1 << ((2 * n) - 1)))){
            
                int count0 = 0;
                int count1 = 0;
                int temp = num;
                // This flag indicates that whether the num is valid
                bool flag = true;
                while(temp){
                    if(temp & 1)    count1++;
                    else            count0++;
                    temp = temp >> 1;
                    if(count0 < count1){
                        flag = false;
                        break;
                    }
                }
                // There must be n '1's and n '0's
                if((count0 != n) || (count1 != n)){
                    flag = false;
                }
                
                if(flag){
                    std::string paren;
                    for(unsigned int i = 0; i < 2 * n; ++i){
                        int mask = (1 << ((2 * n) - i - 1));
                        if(num & mask){
                            paren.push_back('(');
                        }
                        else{
                            paren.push_back(')');
                        }
                    }
                    res.push_back(paren);
                }
            }
            num++;
        }
        return res;

    }
};
