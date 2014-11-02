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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if(root == null){
            return ret;
        }
        
        // false: currently from left to right
        // true: currently from right to left
        boolean direction = false;
        Stack<TreeNode> active = new Stack<TreeNode>();
        active.push(root);
        
        while(!active.empty()){
            Stack<TreeNode> next = new Stack<TreeNode>();
            List<Integer> element = new ArrayList<Integer>();
            while(!active.empty()){
                TreeNode temp = active.pop();
                element.add(temp.val);
                if(direction){
                    if(temp.right != null){
                        next.add(temp.right);
                    }
                    if(temp.left != null){
                        next.add(temp.left);
                    }
                }
                else{
                    if(temp.left != null){
                        next.add(temp.left);
                    }
                    if(temp.right != null){
                        next.add(temp.right);
                    }
                }
            }
            direction = !direction;
            active = next;
            ret.add(element);
        }
        
        return ret;
    }
}
