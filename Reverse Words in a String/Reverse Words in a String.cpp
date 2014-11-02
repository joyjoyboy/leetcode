class Solution {
public:
    void reverseWords(string &s) {
        std::vector<string> all;
        all.clear();
        string temp;
        temp.clear();
        for(unsigned int i = 0; i < s.size(); ++i){
            if(s[i] != ' '){
                temp.push_back(s[i]);
            }
            else if(!temp.empty()){
                all.push_back(temp);
                temp.clear();
            }
        }
        if(!temp.empty()){
            all.push_back(temp);
        }
        string ret;
        ret.clear();

        for(int i = all.size() - 1; i >= 0; --i){
            for(unsigned int j = 0; j < all[i].size(); ++j){
                ret.push_back(all[i][j]);
            }
            if(i)
                ret.push_back(' ');
        }
        s = ret;
    }
};
