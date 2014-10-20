class Solution {
public:

    int findRow(std::vector<std::vector<int> >& matrix, int target, int left, int right){
        if(left == right)   return left;
        
        int mid = (left + right) / 2;
        if((left == mid) || (right == mid)){
            return (matrix[right][0] > target) ? left : right;
        }
        else{
            return (matrix[mid][0] > target) ? findRow(matrix, target, left, mid - 1) : findRow(matrix, target, mid, right);
        }
    }

    int findColomn(std::vector<std::vector<int> >& matrix, int target, int row, int left, int right){
        if(left == right)   return left;
        
        int mid = (left + right) / 2;
        if((left == mid) || (right == mid)){
            return (matrix[row][right] > target) ? left : right;
        }
        else{
            return (matrix[row][mid] > target) ? findColomn(matrix, target, row, left, mid - 1) : findColomn(matrix, target, row, mid, right);
        }
    }

    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        if(matrix.empty())      return false;
        if(matrix[0].empty())   return false;
        
        int rowSize = matrix.size();
        int colomnSize = matrix[0].size();
        int row = findRow(matrix, target, 0, rowSize - 1);
        int colomn = findColomn(matrix, target, row, 0, colomnSize - 1);
        
        if(matrix[row][colomn] == target)   return true;
        else                                return false;
    }
};
