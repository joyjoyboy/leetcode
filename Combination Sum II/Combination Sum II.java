public class Solution {
    
    private void helper(List<List<Integer>> ret, List<Integer> sol, int start, int target, int[] num){
        if(target < 0)      return;
        else if(target == 0){
            ret.add(new ArrayList<Integer>(sol));
            return;
        }
        else{
            for(int i = start; i < num.length; ++i){
                sol.add(num[i]);
                target -= num[i];
                helper(ret, sol, i + 1, target, num);
                target += num[i];
                sol.remove(sol.size() - 1);
                while(i < num.length - 1 && num[i + 1] == num[i])       ++i;
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        
        Arrays.sort(num);
        List<Integer> sol = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, sol, 0, target, num);
        return res;
        
    }
}
