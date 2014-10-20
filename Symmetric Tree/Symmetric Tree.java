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
    private boolean recur(TreeNode n1, TreeNode n2){
        if(n1 != null && n2 != null){
            if(n1.val != n2.val)    return false;
            else                    return recur(n1.left, n2.right) && recur(n1.right, n2.left);
        }
        else if(n1 == null && n2 == null){
            return true;
        }
        else{
            return false;
        }
    }
    */
    
    public boolean isSymmetric(TreeNode root) {
        // Recursive solution
        
        /*if(root == null){
            return true;
        }
        
        return recur(root.left, root.right);
        */
        
        // Non-recursive solution
        if(root == null){
            return true;
        }
        
        if(root.left != null && root.right != null){
            // Do nothing
        }
        else if(root.left == null && root.right == null){
            return true;
        }
        else{
            return false;
        }
        
        List<TreeNode> workingList = new ArrayList<TreeNode>();
        workingList.add(root.left);
        workingList.add(root.right);
        
        while(!workingList.isEmpty()){
            if(workingList.size() % 2 == 1){
                return false;
            }
            else{
                TreeNode first = workingList.remove(0);
                TreeNode second = workingList.remove(workingList.size() - 1);
                if(first.val != second.val){
                    return false;
                }
                
                if(first.left != null && second.right != null){
                    workingList.add(second.right);
                    workingList.add(0, first.left);
                }
                else if(first.left == null && second.right == null){
                    // Do nothing
                }
                else{
                    return false;
                }
                
                if(first.right != null && second.left != null){
                    workingList.add(second.left);
                    workingList.add(0, first.right);
                }
                else if(first.right == null && second.left == null){
                    // Do nothing
                }
                else{
                    return false;
                }
            }
            
        }
        
        return true;
    }
}
