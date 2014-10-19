public class Solution {
    
    private boolean isValid(int[] board, int row, int col){
        for(int i = 0; i < row; ++i){
            // If queens on two rows share the same column or diagonal
            // Return false
            if((col == board[i]) || (Math.abs(row - i) == Math.abs(col - board[i]))){
                return false;
            }
        }
        return true;
    }
    
    private void recur(int[] board, int row, int n, int[] counter){
        if(row == n){
            ++counter[0];
            return;
        }
        
        for(int i = 0; i < n; ++i){
            if(isValid(board, row, i)){
                board[row] = i;
                recur(board, row + 1, n, counter);
                board[row] = -1;
            }
        }
        
        return;
    }
    
    public int totalNQueens(int n) {
        int[] counter = new int[1];
        int[] board = new int[n];
        counter[0] = 0;
        for(int i = 0; i < n; ++i){
            board[i] = -1;
        }
        recur(board, 0, n, counter);
        return counter[0];
    }
}
