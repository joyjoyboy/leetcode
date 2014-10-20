class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        int n = matrix.size();
        if(!n || (n == 1))  return;
        
        int row = 0;
        int colomn = 0;
        
        if(n % 2){
            row = n / 2 + 1;
            colomn = n / 2;
        }
        else{
            row = n / 2;
            colomn = n / 2;
        }
        for(unsigned int i = 0; i < row; ++i){
            for(unsigned int j = 0; j < colomn; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];          
                matrix[j][n - i - 1] = temp;
            }
        }
    }
};
