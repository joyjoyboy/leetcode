class Solution {
public:

    void sort(std::vector<int>& S){
        if(S.size() < 2)        return;
        
        for(unsigned int i = 1; i < S.size(); ++i){
            for(unsigned int j = 0; j < i; ++j){
                if(S[i] < S[j]){
                    int tmp = S[i];
                    S[i] = S[j];
                    S[j] = tmp;
                }
            }
        }
    }

    std::vector<std::vector<int> >  getCombination(std::vector<int>& S, int n, int k){
        std::vector<std::vector<int> >  result;
        if(n < k)                       return result;
        if(!n || !k)                    return result;
        
        if(k == 1){
            for(unsigned int i = 0; i < n; ++i){
                std::vector<int>    element;
                element.push_back(S[i]);
                result.push_back(element);
            }
            return result;
        }
        
        for(int i = k; i <= n; ++i){
            std::vector<std::vector<int> >  tmp = getCombination(S, i - 1, k - 1);
            for(int j = 0; j < tmp.size(); ++j){
                tmp[j].push_back(S[i - 1]);
                result.push_back(tmp[j]);
            }
        }
        
        return result;
    }


    vector<vector<int> > subsets(vector<int> &S) {
        std::vector<int>    emptySet;
        std::vector<std::vector<int> >  res;
        std::vector<std::vector<int> >  accu;
        res.push_back(emptySet);
        
        // Sorting vector S
        sort(S);
        
        for(unsigned int i = 1; i <= S.size(); ++i){
            accu = getCombination(S, S.size(), i);
            for(unsigned int j = 0; j < accu.size(); ++j){
                res.push_back(accu[j]);
            }
        }
        
        return res;
    }
};
