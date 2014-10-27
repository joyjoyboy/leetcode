public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rowSize = matrix.length;
        if(rowSize == 0)                        return 0;
        int colSize = matrix[0].length;
        if(colSize == 0)                        return 0;
        
        int maxArea = 0;
        for(int i = 0; i < rowSize; ++i){
            List<Integer> height = new ArrayList<Integer>();
            
            for(int j = 0; j < colSize; ++j){
                if(matrix[i][j] == '1'){
                    int currHeight = 1;
                    while(currHeight + i < rowSize){
                        if(matrix[currHeight + i][j] == '0'){
                            break;
                        }
                        else{
                            ++currHeight;
                        }
                    }
                    
                    height.add(currHeight);
                    for(int p = 0; p < height.size(); ++p){
                        int len = height.size() - p;
                        height.set(p, Math.min(height.get(p), currHeight));
                        int h = height.get(p);
                        maxArea = Math.max(maxArea, h * len);
                    }
                }
                else{
                    height.clear();
                }
            }
        }
        
        return maxArea;
    }
}
