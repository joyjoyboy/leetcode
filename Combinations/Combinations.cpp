class Solution {
public:

    vector<vector<int> > combine(int n, int k) {
        std::vector<std::vector<int> >  res;
        if(!n || !k)    return res;
        if(n < k)       return res;
        
        if(k == 1){
            for(unsigned int i = 0; i < n; ++i){
                std::vector<int> ret;
                ret.push_back(i + 1);
                res.push_back(ret);
            }
            return res;
        }
        else{
            for(unsigned int i = k; i <= n; ++i){
                std::vector<std::vector<int> > tmp = combine(i - 1, k - 1);
                //if(tmp.empty())     continue;
                for(unsigned int j = 0; j < tmp.size(); ++j){
                    tmp[j].push_back(i);
                    res.push_back(tmp[j]);
                }
            }
        }
        return res;
    }
};
