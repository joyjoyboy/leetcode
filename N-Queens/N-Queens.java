public class Solution {
    
    private boolean isValid(int col, int row, int n, String[] solution){
        
        for(int i = 0; i < row; ++i){
            int qcol = solution[i].indexOf('Q');
            if(qcol == col){
                return false;
            }
            int rowDistance = Math.abs(row - i);
            int colDistance = Math.abs(col - qcol);
            if(rowDistance == colDistance){
                return false;
            }
        }
        return true;
    }
    
    public void GetCombination(List<String[]> res, String[] solution, int row){
        int n = solution.length;
        if(row == n){
            res.add(solution.clone());
            return;
        }
        else{
            for(int col = 0; col < n; ++col){
                if(!isValid(col, row, n, solution)){
                    continue;
                }
                else{
                    char[] tmp = new char[n];
                    Arrays.fill(tmp, '.');
                    tmp[col] = 'Q';
                    
                    solution[row] = String.copyValueOf(tmp);
                    GetCombination(res, solution, row + 1);
                }
            }
            return;
        }
    }
    
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        String[] solution = new String[n];
        
        GetCombination(res, solution, 0);
        
        return res;
        
    }
}
