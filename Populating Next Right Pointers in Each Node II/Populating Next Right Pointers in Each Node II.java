/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        TreeLinkNode temp = root.next;
        while(temp != null){
            if(temp.left != null){
                temp = temp.left;
                break;
            }
            else if(temp.right != null){
                temp = temp.right;
                break;
            }
            temp = temp.next;
        }
        
        if(root.left != null){
            // Populate all the way to the right
            if(root.right != null){
                root.left.next = root.right;
            }
            else{
                root.left.next = temp;
            }
        }
        
        if(root.right != null){
            root.right.next = temp;
        }
        
        connect(root.right);
        connect(root.left);
        
        
        return;
    }
}
