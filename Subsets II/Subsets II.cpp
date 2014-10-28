class Solution {
public:

    void helper(std::vector<std::vector<int> >& res, std::vector<int>& currSol, int index, std::vector<int>& S){
        for(int i = index; i < S.size(); ++i){
            currSol.push_back(S[i]);
            res.push_back(currSol);
            if(i < S.size() - 1){
                helper(res, currSol, index + 1, S);
                while(i < S.size() - 1 && S[i] == S[i + 1])     ++i;
            }
            currSol.pop_back();
        }
    }

    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        std::vector<std::vector<int> > res;
        std::vector<int> sol;
        //std::sort(S.begin(), S.end(), [](int a, int b){return a < b;});
        std::sort(S.begin(), S.end());
        res.push_back(sol);
        helper(res, sol, 0, S);
        return res;
    }
};
