class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> > &obstacleGrid) {
        
        std::vector<std::vector<int> >  record;
        int rowSize = obstacleGrid.size();
        if(!rowSize)                    return 0;
        int colSize = obstacleGrid[0].size();
        if(!colSize)                    return 0;
        
        for(unsigned int row = 0; row < rowSize; ++row){
            std::vector<int>    rowElement;
            for(unsigned int col = 0; col < colSize; ++col){
                rowElement.push_back(0);
            }
            record.push_back(rowElement);
        }
        
        for(unsigned int row = 0; row < rowSize; ++row){
            for(unsigned int col = 0; col < colSize; ++col){
                if(!row && !col){
                    record[row][col] = (!obstacleGrid[row][col]);
                }
                else if(!row){
                    record[row][col] = (record[row][col - 1] && !obstacleGrid[row][col]);
                }
                else if(!col){
                    record[row][col] = (record[row - 1][col] && !obstacleGrid[row][col]);
                }
                else{
                    if(!obstacleGrid[row][col]){
                        record[row][col] = record[row][col - 1] + record[row - 1][col];
                    }
                    else{
                        record[row][col] = 0;
                    }
                }
            }
        }
        
        return record[rowSize - 1][colSize - 1];
    }
};
