public class Solution {
    public void rotate(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        if(rlen != clen){
            return;
        }
        int rowSize = 0;
        int colSize = 0;
        if(rlen % 2 == 1){
            rowSize = rlen / 2 + 1;
            colSize = rlen / 2;
        }
        else{
            rowSize = rlen / 2;
            colSize = rlen / 2;
        }
        for(int i = 0; i < rowSize; ++i){
            for(int j = 0; j < colSize; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[clen - j - 1][i];
                matrix[clen - j - 1][i] = matrix[clen - i - 1][clen - j - 1];
                matrix[clen - i - 1][clen - j - 1] = matrix[j][clen - i - 1];
                matrix[j][clen - i - 1] = temp;
            }
        }
        return;
    }
}
