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
    
    private int helper(TreeNode root, int prev){
        if(root == null)        return 0;
        prev *= 10;
        prev += root.val;
        if(root.left == null && root.right == null){
            return prev;
        }
        return helper(root.left, prev) + helper(root.right, prev);
    }
    
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}
