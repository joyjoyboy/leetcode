public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int[] row = new int[9];
        int[] col = new int[9];
        int[][] cub = new int[3][3];
        
        for(int i = 0; i < 9; ++i){
            row[i] = 0;
            col[i] = 0;
            cub[i / 3][i % 3] = 0;
        }
        
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == '.'){
                    continue;
                }
                else{
                    int n = board[i][j] - '0' - 1;
                    int mask = 1 << n;
                    if((row[i] & mask) != 0)      return false;
                    else                        row[i] |= mask;
                    if((col[j] & mask) != 0)      return false;
                    else                        col[j] |= mask;
                    if((cub[i/3][j/3] & mask) != 0)   return false;
                    else                            cub[i/3][j/3] |= mask;
                }
            }
        }
        return true;
    }
}
