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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        if(n == 0){
            return head;
        }
        
        for(int i = 0; i < n; ++i){
            ptr2 = ptr2.next;
        }
        
        if(ptr2 == null){
            return head.next;
        }
        
        while(ptr2.next != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        ptr1.next = ptr1.next.next;
        return head;
    }
}
