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
    
    private int recur(TreeNode root, int[] max){
        
        // Get the sum of all nodes on a branch
        int leftval = 0;
        if(root.left != null){
            leftval = recur(root.left, max);
        }
        int rightval = 0;
        if(root.right != null){
            rightval = recur(root.right, max);
        }
        
        int retval = 0;
        
        if(root.left != null && root.right != null){
            max[0] = Math.max(max[0], leftval + rightval + root.val);
            max[0] = Math.max(max[0], leftval + root.val);
            max[0] = Math.max(max[0], leftval);
            max[0] = Math.max(max[0], rightval + root.val);
            max[0] = Math.max(max[0], rightval);
            max[0] = Math.max(max[0], root.val);
            retval = (Math.max(leftval, rightval) > 0) ? Math.max(leftval, rightval) + root.val : root.val;
        }
        else if(root.left != null){
            max[0] = Math.max(max[0], leftval + root.val);
            max[0] = Math.max(max[0], leftval);
            max[0] = Math.max(max[0], root.val);
            retval = (leftval > 0) ? leftval + root.val : root.val;
        }
        else if(root.right != null){
            max[0] = Math.max(max[0], rightval + root.val);
            max[0] = Math.max(max[0], rightval);
            max[0] = Math.max(max[0], root.val);
            retval = (rightval > 0) ? rightval + root.val : root.val;
        }
        else{
            max[0] = Math.max(max[0], root.val);
            retval = root.val;
        }
        
        return retval;
    }
    
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int[] max = new int[1];
        max[0] = root.val;
        recur(root, max);
        
        return max[0];
    }
}
