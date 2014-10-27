/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private void recur(TreeNode root, List<Integer> solution, List<List<Integer>> ret, int target, int sum){
        if(root == null){
            return;
        }
        
        sum += root.val;
        
        if((root.left == null) && (root.right == null)){
            if(target == sum){
                solution.add(root.val);
                ret.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size() - 1);
            }
            return;
        }
        
        solution.add(root.val);
        recur(root.left, solution, ret, target, sum);
        recur(root.right, solution, ret, target, sum);
        solution.remove(solution.size() - 1);
        
        return;
    }
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        
        if(root != null){
            recur(root, sol, ret, sum, 0);
        }
        
        return ret;
    }
}
