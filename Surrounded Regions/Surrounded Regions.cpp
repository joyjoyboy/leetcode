class Solution {
public:

    // Stack overflows while testing large data set
    // 100*100 input is fine, while 200*200 input will fail the test
    // And it says "Runtime error"!
    // WTF!
    /*
    void propagate(std::vector<std::vector<char> >& board, int row, int col){
        int rowSize = board.size();
        int colSize = board[0].size();
        
        board[row][col] = '1';
        
        if(row < rowSize - 1){
            if(board[row + 1][col] == 'O'){
                propagate(board, row + 1, col);
            }
        }
        if(row > 0){
            if(board[row - 1][col] == 'O'){
                propagate(board, row - 1, col);
            }
        }
        if(col < colSize - 1){
            if(board[row][col + 1] == 'O'){
                propagate(board, row, col + 1);
            }
        }
        if(col > 0){
            if(board[row][col - 1] == 'O'){
                propagate(board, row, col - 1);
            }
        }
        
        return;
    }

    void solve(vector<vector<char>> &board) {
        
        if(board.size() == 0){
            return;
        }
        else if(board[0].size() == 0){
            return;
        }
        
        for(int i = 0; i < board.size(); ++i){
            if(board[i][0] == 'O'){
                propagate(board, i, 0);
            }
            if(board[i][board[0].size() - 1] == 'O'){
                propagate(board, i, board[0].size() - 1);
            }
        }
        
        for(int i = 0; i < board[0].size(); ++i){
            if(board[0][i] == 'O'){
                propagate(board, 0, i);
            }
            if(board[board.size() - 1][i] == 'O'){
                propagate(board, board.size() - 1,i);
            }
        }
        
        for(int i = 0; i < board.size(); ++i){
            for(int j = 0; j < board[0].size(); ++j){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
        
        return;
    }
    */
    
    void solve(vector<vector<char>> &board) {
        
        if(board.size() == 0){
            return;
        }
        else if(board[0].size() == 0){
            return;
        }
        
        std::queue<int> xIndex;
        std::queue<int> yIndex;
        
        for(int i = 0; i < board.size(); ++i){
            if(board[i][0] == 'O'){
                xIndex.push(i);
                yIndex.push(0);
            }
            if(board[i][board[0].size() - 1] == 'O'){
                xIndex.push(i);
                yIndex.push(board[0].size() - 1);
            }
        }
        
        for(int i = 0; i < board[0].size(); ++i){
            if(board[0][i] == 'O'){
                xIndex.push(0);
                yIndex.push(i);
            }
            if(board[board.size() - 1][i] == 'O'){
                xIndex.push(board.size() - 1);
                yIndex.push(i);
            }
        }
        
        int rowSize = board.size();
        int colSize = board[0].size();
        
        while(!xIndex.empty()){
            int row = xIndex.front();
            int col = yIndex.front();
            
            xIndex.pop();
            yIndex.pop();

            board[row][col] = 'A';
        
            if(row < rowSize - 1){
                if(board[row + 1][col] == 'O'){
                    xIndex.push(row + 1);
                    yIndex.push(col);
                }
            }
            if(row > 0){
                if(board[row - 1][col] == 'O'){
                    xIndex.push(row - 1);
                    yIndex.push(col);
                }
            }
            if(col < colSize - 1){
                if(board[row][col + 1] == 'O'){
                    xIndex.push(row);
                    yIndex.push(col + 1);
                }
            }
            if(col > 0){
                if(board[row][col - 1] == 'O'){
                    xIndex.push(row);
                    yIndex.push(col - 1);
                }
            }
        }
        
        for(int i = 0; i < board.size(); ++i){
            for(int j = 0; j < board[0].size(); ++j){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
        
        return;
    }
    
};
