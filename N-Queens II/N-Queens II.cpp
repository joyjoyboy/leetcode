class Solution {
public:

    bool isValid(std::vector<int>& solution, int row, int col){
        for(int i = 0; i < solution.size(); ++i){
            if(solution[i] == col || abs(solution[i] - col) == abs(i - row)){
                return false;
            }
        }
        return true;
    }

    void recur(std::vector<int>& solution, int n, int level, int& counter){
        if(level == n){
            ++counter;
            return;
        }
        for(int i = 0; i < n; ++i){
            if(isValid(solution, level, i)){
                solution.push_back(i);
                recur(solution, n, level + 1, counter);
                solution.pop_back();
            }
        }
    }

    int totalNQueens(int n) {
        int counter = 0;
        std::vector<int> solution;
        recur(solution, n, 0, counter);
        return counter;
    }
};
