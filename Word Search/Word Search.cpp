class Solution {
public:

    bool recur(std::vector<std::vector<char> >& board, std::vector<std::vector<bool> >& visited, std::string word, int x, int y){
        if(word.empty())        return true;
        char curr = word[0];
        for(int i = -1; i <= 1; ++i){
            for(int j = -1; j <= 1; ++j){
                if((!i && !j) || (i && j)){
                    continue;
                }
                int xIndex = x + i;
                int yIndex = y + j;
                if(xIndex < 0 || xIndex >= board.size() || yIndex < 0 || yIndex > board[0].size()){
                    continue;
                }
                
                if(board[xIndex][yIndex] == curr && visited[xIndex][yIndex] == false){
                    visited[xIndex][yIndex] = true;
                    std::string newWord = word.substr(1, word.size() - 1);
                    bool res = recur(board, visited, newWord, xIndex, yIndex);
                    visited[xIndex][yIndex] = false;
                    if(res)         return true;
                }
            }
        }
        return false;
    }

    bool exist(vector<vector<char> > &board, string word) {
        std::vector<std::vector<bool> > visited;
        for(int i = 0; i < board.size(); ++i){
            visited.push_back(std::vector<bool>());
            for(int j = 0; j < board[0].size(); ++j){
                visited[i].push_back(false);
            }
        }

        char curr = word[0];
        for(int i = 0; i < board.size(); ++i){
            for(int j = 0; j < board[0].size(); ++j){
                if(board[i][j] == curr && visited[i][j] == false){
                    visited[i][j] = true;
                    std::string newWord = word.substr(1, word.size() - 1);
                    bool res = recur(board, visited, newWord, i, j);
                    visited[i][j] = false;
                    if(res)         return true;
                }
            }
        }

        return false;
    }
};
