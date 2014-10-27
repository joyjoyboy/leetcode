class Solution {
public:

    std::vector<int> recur(std::vector<std::vector<int> > &triangle, int level){
        std::vector<int>    res;
        std::vector<int>    prev;
        if(!level)          return res;
        if(level == 1)      return triangle[0];
        
        res = triangle[level - 1];
        prev = recur(triangle, level - 1);
        res[0] += prev[0];
        for(unsigned int i = 1; i < res.size() - 1; ++i){
            res[i] += (prev[i - 1] < prev[i]) ? prev[i - 1] : prev[i];
        }
        res[res.size() - 1] += prev[res.size() - 2];
        
        return res;
    }



    int minimumTotal(vector<vector<int> > &triangle) {
        std::vector<int>    res;
        res = recur(triangle, triangle.size());
        if(res.empty())     return 0;
        
        int ret = res[0];
        for(unsigned int i = 0; i < res.size(); ++i){
            ret = (ret < res[i]) ? ret : res[i];
        }
        return ret;
    }
};
