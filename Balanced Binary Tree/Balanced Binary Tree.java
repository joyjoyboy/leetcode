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
    
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        else{
            return Math.max(depth(node.left), depth(node.right)) + 1;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        else{
            return Math.abs(depth(root.left) - depth(root.right)) > 1 ? false : isBalanced(root.left) && isBalanced(root.right);
        }
    }
}
