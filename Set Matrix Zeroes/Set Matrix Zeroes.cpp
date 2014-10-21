class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) {
        std::set<int> zeroRows;
        std::set<int> zeroCols;
        for(unsigned int i = 0; i < matrix.size(); ++i){
            for(unsigned int j = 0; j < matrix[i].size(); ++j){
                if(!matrix[i][j]){
                    zeroRows.insert(i);
                    zeroCols.insert(j);
                }
            }
        }
        
        for(unsigned int i = 0; i < matrix.size(); ++i){
            for(unsigned int j = 0; j < matrix[i].size(); ++j){
                if(zeroRows.find(i) != zeroRows.end()){
                    matrix[i][j] = 0;
                }
                if(zeroCols.find(j) != zeroCols.end()){
                    matrix[i][j] = 0;
                }
            }
        }
    }
};
