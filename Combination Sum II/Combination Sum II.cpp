class Solution {
public:

    void comb(std::vector<std::vector<int> >& ret, std::vector<int>& sol, std::vector<int>& num, int target, int index){
        if(target == 0){
            ret.push_back(sol);
            return;
        }
        else if(target < 0 || index == num.size()){
            return;
        }
        else{
            for(int i = index; i < num.size(); ++i){
                int getNum = num[i];
                target -= getNum;
                sol.push_back(getNum);
                comb(ret, sol, num, target, i + 1);
                sol.pop_back();
                target += getNum;
                while(i != num.size() - 1 && num[i + 1] == getNum){
                    ++i;
                }
            }
            return;
        }
    }

    vector<vector<int> > combinationSum2(vector<int> &num, int target) {
        std::vector<std::vector<int> > ret;
        std::vector<int> sol;
        std::sort(num.begin(), num.end());
        comb(ret, sol, num, target, 0);
        return ret;
    }
};
