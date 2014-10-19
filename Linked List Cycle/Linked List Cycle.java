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
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null){
            return false;
        }
        
        ListNode fastPtr = head.next;
        
        while(fastPtr != null){
            if(fastPtr == head){
                return true;
            }
            else{
                head = head.next;
                fastPtr = fastPtr.next;
                if(fastPtr == null){
                    return false;
                }
                else{
                    fastPtr = fastPtr.next;
                }
            }
        }
        
        return false;
    }
}
