class Solution {
public:
    int uniquePaths(int m, int n) {
        std::vector<std::vector<int> >  res;
        for(unsigned int i = 0; i < m; ++i){
            std::vector<int>    row;
            for(unsigned int j = 0; j < n; ++j){
                if(j && i)      row.push_back(0);
                else            row.push_back(1);
            }
            res.push_back(row);
        }
        for(unsigned int i = 0; i < m; ++i){
            for(unsigned int j = 0; j < n; ++j){
                if(j && i){
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }
};
