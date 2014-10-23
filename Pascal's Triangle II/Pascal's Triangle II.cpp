class Solution {
public:
    vector<int> getRow(int rowIndex) {
        std::vector<int>    ret;

        while(rowIndex-- >= 0){
            ret.push_back(1);
            for(int i = ret.size() - 2; i >= 1; --i){
                ret[i] = ret[i - 1] + ret[i];
            }
        }
        
        return ret;
    }
};
