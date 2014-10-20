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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> bfs = new ArrayList<List<Integer>>();
        if(root == null){
            return bfs;
        }
        
        List<TreeNode> workingList = new ArrayList<TreeNode>();
        workingList.add(root);
        List<Integer> rootval = new ArrayList<Integer>();
        rootval.add(root.val);
        bfs.add(0, rootval);
        while(!workingList.isEmpty()){
            List<TreeNode> newList = new ArrayList<TreeNode>();
            List<Integer> values = new ArrayList<Integer>();
            for(TreeNode n : workingList){
                if(n.left != null){
                    newList.add(n.left);
                    values.add(n.left.val);
                }
                if(n.right != null){
                    newList.add(n.right);
                    values.add(n.right.val);
                }
            }
            workingList = newList;
            if(!values.isEmpty()){
                bfs.add(0, values);
            }
        }
        
        return bfs;
    }
}
