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
    public ListNode rotateRight(ListNode head, int n) {
        if(n == 0){
            return head;
        }
        if(head == null){
            return head;
        }
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(n-- > 0){
            if(fastPtr.next != null){
                fastPtr = fastPtr.next;
            }
            else{
                fastPtr = head;
            }
        }
        
        if(slowPtr == fastPtr){
            return head;
        }
        
        while(fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        
        ListNode retval = slowPtr.next;
        fastPtr.next = head;
        slowPtr.next = null;
        
        return retval;
    }
}
