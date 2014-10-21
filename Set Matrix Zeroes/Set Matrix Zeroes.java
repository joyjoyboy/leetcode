public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)     return;
        
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        
        for(int i = 0; i < matrix.length; ++i)              row[i] = false;
        for(int i = 0; i < matrix[0].length; ++i)           col[i] = false;
        
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for(int i = 0; i < matrix.length; ++i){
            if(row[i]){
                for(int j = 0; j < matrix[0].length; ++j){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < matrix[0].length; ++j){
            if(col[j]){
                for(int i = 0; i < matrix.length; ++i){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
