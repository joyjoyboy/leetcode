class Solution {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        
        if(board.empty())  return false;
        
        int row[9];
        int col[9];
        int cub[3][3];
        for(unsigned int i = 0; i < 9; ++i){
            row[i] = 0;
            col[i] = 0;
        }
        for(unsigned int i = 0; i < 3; ++i){
            for(unsigned int j = 0; j < 3; ++j){
                cub[i][j] = 0;
            }
        }
        
        for(unsigned int i = 0; i < 9; ++i){
            for(unsigned int j = 0; j < 9; ++j){
                if(board[i][j] == '.')      continue;
                int num;
                num = board[i][j] - '0';
                num = 1 << num;
                if(num & row[i])            return false;
                else                        row[i] |= num;
                if(num & col[j])            return false;
                else                        col[j] |= num;
                if(num & cub[i/3][j/3])     return false;
                else                        cub[i/3][j/3] |= num;
            }
        }
        
        return true;
    }
};
