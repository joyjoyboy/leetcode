/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)            return head;
        if(head.next == null)       return head;
        ListNode fastNode = head.next;
        ListNode Node = head;
        
        while(fastNode != null){
            if(fastNode.val == Node.val){
                fastNode = fastNode.next;
                Node.next = fastNode;
            }
            else{
                fastNode = fastNode.next;
                Node = Node.next;
            }
        }
        
        return head;
    }
}
