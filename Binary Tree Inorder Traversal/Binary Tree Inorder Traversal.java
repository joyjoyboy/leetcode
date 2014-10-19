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
    
    // Recursive solution
    /*
    private void recur(List<Integer> list, TreeNode root){
        if(root.left != null){
            recur(list, root.left);
        }
        list.add(root.val);
        if(root.right != null){
            recur(list, root.right);
        }
    }
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null)
            stack.push(root);
        else
            return res;
        
        TreeNode prev = null;
        while(stack.empty() != true){
            TreeNode curr = stack.pop();
            // Traversing down the tree
            if(prev == null || curr == prev.left || curr == prev.right){
                if(curr.right != null){
                    stack.push(curr.right);
                }
                if(curr.left != null){
                    stack.push(curr);
                    stack.push(curr.left);
                }
                else{
                    res.add(curr.val);
                }
            }
            // Traversing up the tree
            else{
                res.add(curr.val);
            }
            prev = curr;
        }
        
        // Recursive solution
        /*
        if(root != null)
            recur(res, root);
        */
        return res;
    }
}
