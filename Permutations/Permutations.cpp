class Solution {
public:

    void recur(std::vector<std::vector<int> >& ret, std::vector<int>& sol, std::vector<int>& num, std::unordered_set<int> usedIndices, int n){
        if(usedIndices.size() >= n){
            ret.push_back(sol);
            return;
        }
        
        for(int i = 0; i < n; ++i){
            if(usedIndices.find(i) != usedIndices.end()){
                continue;
            }
            
            int element = num[i];
            sol.push_back(element);
            usedIndices.insert(i);
            recur(ret, sol, num, usedIndices, n);
            usedIndices.erase(i);
            sol.pop_back();
        }
        
        return;
    }

    vector<vector<int> > permute(vector<int> &num) {
        std::vector<std::vector<int> > ret;
        std::vector<int> sol;
        std::unordered_set<int> usedIndices;
        
        int n = num.size();
        recur(ret, sol, num, usedIndices, n);
        
        return ret;
    }
};
