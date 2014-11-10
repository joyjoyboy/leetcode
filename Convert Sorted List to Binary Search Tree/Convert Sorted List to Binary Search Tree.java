/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    
    static ListNode lNode;
    
    private int getLen(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    private TreeNode recur(ListNode head, int start, int end){
        
        if(start > end){
            return null;
        }
        
        int mid = start + end;
        mid = mid / 2;
        TreeNode left = recur(head, start, mid - 1);
        TreeNode root = new TreeNode(lNode.val);
        lNode = lNode.next;
        TreeNode right = recur(head, mid + 1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int len = getLen(head);
        lNode = head;
        
        return recur(head, 0, len - 1);
    }
}
