public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowMin = 0;
        int rowMax = matrix.length;
        int rowMid = (rowMin + rowMax) / 2;
        int prevMid = rowMid;
        
        do{
            prevMid = rowMid;
            if(matrix[rowMid][0] == target){
                return true;
            }
            else if(matrix[rowMid][0] < target){
                rowMin = rowMid;
                rowMid = (rowMin + rowMax) / 2;
            }
            else{
                rowMax = rowMid;
                rowMid = (rowMin + rowMax) / 2;
            }
        }while(prevMid != rowMid);
        
        int colMin = 0;
        int colMax = matrix[0].length;
        int colMid = (colMin + colMax) / 2;
        int prevCol = colMid;
        
        do{
            prevCol = colMid;
            if(matrix[rowMid][colMid] == target){
                return true;
            }
            else if(matrix[rowMid][colMid] < target){
                colMin = colMid;
                colMid = (colMin + colMax) / 2;
            }
            else{
                colMax = colMid;
                colMid = (colMin + colMax) / 2;
            }
        }while(prevCol != colMid);
        
        return false;
        
    }
}
