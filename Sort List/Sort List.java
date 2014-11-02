/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode fakeHead = new ListNode(0);
        ListNode curr = fakeHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }
        else{
            curr.next = l2;
        }
        
        return fakeHead.next;
    }
    
    public ListNode sortList(ListNode head) {
        // Length == 0 or 1
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;
        while(fastPtr != null){
            fastPtr = fastPtr.next;
            if(fastPtr != null){
                fastPtr = fastPtr.next;
            }
            else{
                break;
            }
            slowPtr = slowPtr.next;
        }
        
        ListNode nextHead = slowPtr.next;
        slowPtr.next = null;
        
        head = sortList(head);
        nextHead = sortList(nextHead);
        
        ListNode newHead = merge(head, nextHead);
        
        return newHead;
    }
}
