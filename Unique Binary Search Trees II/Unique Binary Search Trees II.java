/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    
    private List<TreeNode> buildTree(int start, int end){
        
        List<TreeNode> ret = new ArrayList<TreeNode>();
        
        if(start > end){
            ret.add(null);
            return ret;
        }
        
        for(int i = start; i <= end; ++i){
            List<TreeNode> left = buildTree(start, i - 1);
            List<TreeNode> right = buildTree(i + 1, end);
            for(int m = 1; m <= left.size(); ++m){
                for(int n = 1; n <= right.size(); ++n){
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left.get(m - 1);
                    newNode.right = right.get(n - 1);
                    ret.add(newNode);
                }
            }
        }
        
        return ret;
    }
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = buildTree(1, n);
        return ret;
    }
}
