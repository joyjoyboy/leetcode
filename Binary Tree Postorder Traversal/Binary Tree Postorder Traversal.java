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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        if(root.left != null && root.right != null){
            List<Integer> l1 = postorderTraversal(root.left);
            List<Integer> l2 = postorderTraversal(root.right);
            List<Integer> l3 = new ArrayList<Integer>();
            l3.add(root.val);
            l1.addAll(l2);
            l1.addAll(l3);
            return l1;
        }
        else if(root.left != null){
            List<Integer> l1 = postorderTraversal(root.left);
            List<Integer> l3 = new ArrayList<Integer>();
            l3.add(root.val);
            l1.addAll(l3);
            return l1;
        }
        else if(root.right != null){
            List<Integer> l1 = postorderTraversal(root.right);
            List<Integer> l3 = new ArrayList<Integer>();
            l3.add(root.val);
            l1.addAll(l3);
            return l1;
        }
        else{
            List<Integer> l1 = new ArrayList<Integer>();
            l1.add(root.val);
            return l1;
        }
    }
}
