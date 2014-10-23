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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stk = new Stack();
        if(root != null){
            stk.push(root);
        }
        while(!stk.empty()){
            TreeNode node = stk.pop();
            if(node.right != null){
                stk.push(node.right);
            }
            if(node.left != null){
                stk.push(node.left);
                node.right = node.left;
                node.left = null;
            }
            else{
                if(stk.empty()){
                    node.right = null;
                }
                else{
                    node.right = stk.peek();
                }
            }
        }
    }
}
