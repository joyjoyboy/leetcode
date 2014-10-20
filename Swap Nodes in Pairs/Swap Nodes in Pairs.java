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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        
        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = fakeHead;
        
        while(first != null && second != null){
            prev.next = second;
            ListNode next = second.next;
            second.next = first;
            first.next = next;
            prev = first;
            
            first = first.next;
            if(first != null){
                second = first.next;
            }
            else{
                second = null;
            }
            
        }
        
        return fakeHead.next;
    }
}
