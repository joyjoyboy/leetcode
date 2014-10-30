class Solution {
public:
    string countAndSay(int n) {
        std::string res;
        if(!n)      return res;
        
        res = "1";
        while(n-- > 1){
            std::string newStr;
            for(unsigned int i = 0; i < res.size();){
                char curr = res[i];
                if(i == res.size() - 1){
                    newStr.push_back('1');
                    newStr.push_back(curr);
                    ++i;
                }
                else{
                    int counter = 1;
                    while(i < res.size()){
                        ++i;
                        if(res[i] == curr){
                            counter++;
                        }
                        else{
                            break;
                        }
                    }
                    char num = counter + '0';
                    newStr.push_back(num);
                    newStr.push_back(curr);
                }
            }
            res = newStr;
        }
        return res;
    }
};
