class Solution {
public:

    // Recursion is straightforward
    // However, it exceeds time limit
/*    
    int recur(std::vector<std::vector<int> >& grid, int x, int y){
        if(!x && !y){
            return grid[x][y];
        }
        else if(!x){
            return grid[x][y] + recur(grid, x, y - 1);
        }
        else if(!y){
            return grid[x][y] + recur(grid, x - 1, y);
        }
        else{
            int fromX = recur(grid, x - 1, y);
            int fromY = recur(grid, x, y - 1);
            return (fromX < fromY) ? fromX + grid[x][y] : fromY + grid[x][y];
        }
    }
*/
    int minPathSum(vector<vector<int> > &grid) {
        int rowSize = grid.size();
        if(!rowSize)    return 0;
        int colomnSize = grid[0].size();
        if(!colomnSize)     return 0;
        
//      return recur(grid, rowSize - 1, colomnSize - 1);
        std::vector<std::vector<int> >  lowestCost;
        for(unsigned int i = 0; i < rowSize; ++i){
            std::vector<int>    row;
            lowestCost.push_back(row);
            for(unsigned int j = 0; j < colomnSize; ++j){
                if(!i && !j){
                    lowestCost[i].push_back(grid[i][j]);
                }
                else if(!i){
                    lowestCost[i].push_back(grid[i][j] + lowestCost[i][j - 1]);
                }
                else if(!j){
                    lowestCost[i].push_back(grid[i][j] + lowestCost[i - 1][j]);
                }
                else{
                    lowestCost[i].push_back(lowestCost[i - 1][j] < lowestCost[i][j - 1] ? lowestCost[i - 1][j] + grid[i][j] : lowestCost[i][j - 1] + grid[i][j]);
                }
            }
        }
        return lowestCost[rowSize - 1][colomnSize - 1];
    }
};
