/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    // OVER ENGINEERING
    // Input tree does not have to be a perfect binary tree
    
    public void connect(TreeLinkNode root) {
        if(root == null)            return;
        TreeLinkNode closet = root.next;
        if(closet != null){
            closet = root.next;
            while(closet.left == null && closet.right == null){
                closet = closet.next;
                if(closet == null){
                    break;
                }
            }
            if(closet != null){
                closet = (closet.left != null) ? closet.left : closet.right;
            }
        }
        
        if(root.left != null){
            if(root.right != null){
                root.left.next = root.right;
            }
            else{
                root.left.next = closet;
            }
        }
        if(root.right != null){
            root.right.next = closet;
        }
        
        connect(root.left);
        connect(root.right);
        
        return;
    }
}
