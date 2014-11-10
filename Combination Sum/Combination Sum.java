public class Solution {
    
    public void GetCombination(int[] candidates, int target, int sum, int level, List<Integer> solution, List<List<Integer>> result){
        if(sum > target){
            return;
        }
        else if(sum == target){
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        else{
            for(int i = level; i < candidates.length; ++i){
                sum += candidates[i];
                solution.add(candidates[i]);
                GetCombination(candidates, target, sum, i, solution, result);
                solution.remove(solution.size() - 1);
                sum -= candidates[i];
            }
        }
        return;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        GetCombination(candidates, target, 0, 0, solution, res);
        return res;
    }
}
