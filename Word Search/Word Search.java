public class Solution {

    private boolean recur(char[][] board, String word, boolean[][] visited, int index, int rowSize, int colSize, int x, int y){
        if(index == word.length()){
            return true;
        }
        
        // Out of boundary
        if((x < 0) || (y < 0) || (x >= rowSize) || (y >= colSize)){
            return false;
        }
        
        if(rowSize * colSize < word.length()){
            return false;
        }
        
        if((board[x][y] == word.charAt(index)) && (visited[x][y] == false)){
            visited[x][y] = true;
            ++index;
            if(recur(board, word, visited, index, rowSize, colSize, x, y + 1) || recur(board, word, visited, index, rowSize, colSize, x + 1, y) || recur(board, word, visited, index, rowSize, colSize, x, y - 1) || recur(board, word, visited, index, rowSize, colSize, x - 1, y)){
                return true;
            }
            else{
                visited[x][y] = false;
                return false;
            }
        }
        else{
            return false;
        }
        
    }
    
    public boolean exist(char[][] board, String word) {
        int rowSize = board.length;
        int colSize = 0;
        if(rowSize != 0){
            colSize = board[0].length;
        }
        
        if((rowSize == 0) || (colSize == 0) || (word.length() == 0)){
            return false;
        }
        
        for(int i = 0; i < rowSize; ++i){
            for(int j = 0; j < colSize; ++j){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[rowSize][colSize];
                    if(recur(board, word, visited, 0, rowSize, colSize, i, j)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

}

