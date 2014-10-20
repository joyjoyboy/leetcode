public class Solution {
    
    private void recur(List<String> ret, char[] solution, int n, int left, int right){
        
        if(left == n && right == n){
            String str = String.valueOf(solution);
            ret.add(str);
            return;
        }
        
        if(left < n){
            solution[left + right] = '(';
            recur(ret, solution, n, left + 1, right);
        }
        
        if(right < left){
            solution[left + right] = ')';
            recur(ret, solution, n, left, right + 1);
        }
        
        return;
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        if(n == 0){
            return ret;
        }
        char[] sol = new char[2 * n];
        recur(ret, sol, n, 0, 0);
        
        return ret;
    }
}
