class Solution {
public:

    void recur(std::vector<std::vector<int> >& res, std::vector<int>& sol, std::vector<int>& candidates, int sum, int target, int index){
        if(index == candidates.size() || sum > target){
            return;
        }
        
        if(sum == target){
            std::vector<int> element(sol);
            res.push_back(element);
            return;
        }
        
        for(int i = index; i < candidates.size(); ++i){
            int num = candidates[i];
            sum += num;
            sol.push_back(num);
            recur(res, sol, candidates, sum, target, i);
            sol.pop_back();
            sum -= num;
        }
        
        return;
    }

    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        std::vector<std::vector<int> > res;
        std::vector<int> sol;
        std::sort(candidates.begin(), candidates.end());
        recur(res, sol, candidates, 0, target, 0);
        return res;
    }
};
