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
    
    private boolean recur(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        else{
            if((root.val >= max) || (root.val <= min)){
                return false;
            }
            else{
                return recur(root.left, min, root.val) && recur(root.right, root.val, max);
            }
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        return recur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
