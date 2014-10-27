class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) {
        int max = 0;
        // Row forms the length
        // Find the maximum height * length
        for(int row = 0; row < matrix.size(); ++row){
            int length = 0;
            std::vector<int> minHeight;
            for(int col = 0; col < matrix[0].size(); ++col){
                if(matrix[row][col] == '1'){
                    ++length;
                    int height = 1;
                    
                    while(row + height < matrix.size()){
                        if(matrix[row + height][col] == '1'){
                            ++height;
                        }
                        else{
                            break;
                        }
                    }
                    
                    minHeight.push_back(height);
                    for(int i = 0; i < minHeight.size(); ++i){
                        minHeight[i] = (minHeight[i] < height) ? minHeight[i] : height;
                        // As length increases, the height is likely to decrease
                        int l = length - i;
                        int area = minHeight[i] * l;
                        max = (max > area) ? max : area;
                    }
                    
                }
                else{
                    length = 0;
                    minHeight.clear();
                }
            }
        }
        
        return max;
    }
};
