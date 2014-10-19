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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)        return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.empty()){
            TreeNode curr = stack.pop();
            if(curr.right != null)      stack.push(curr.right);
            if(curr.left != null)       stack.push(curr.left);
            res.add(curr.val);
        }
        
        return res;
    }
}
