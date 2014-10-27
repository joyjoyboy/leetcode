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
    public ListNode partition(ListNode head, int x) {
        ListNode virtualHead = new ListNode(x - 1);
        virtualHead.next = head;
        ListNode beforePivot = virtualHead;
        
        while(beforePivot != null){
            while(beforePivot.next != null){
                if(beforePivot.next.val < x){
                    beforePivot = beforePivot.next;
                }
                else{
                    break;
                }
            }
            if(beforePivot.next == null){       // No pivot left
                break;
            }
            // At this point, beforePivot points to the node right before pivot
            // beforePivot.next points to the pivot node
            // Need to get the node(s) that requires rearrangement
            
            ListNode lastPivot = beforePivot.next;
            while(lastPivot.next != null){
                if(lastPivot.next.val >= x){
                    lastPivot = lastPivot.next;
                }
                else{
                    break;
                }
            }
            if(lastPivot.next == null){         // No node requires rearrangement
                break;
            }
            
            // At this point, lastPivot points to the last pivot node
            // lastPivot.next is the fist node that is going to be moved
            // Find all following nodes that are less than x until end(nullptr) or a pivot node
            
            ListNode end = lastPivot.next;
            while(end.next != null){
                if(end.next.val < x){
                    end = end.next;
                }
                else{
                    break;
                }
            }
            
            ListNode swap = lastPivot.next;     // Start of the to-be-moved list
            lastPivot.next = end.next;          // to-be-moved list are removed
            end.next = beforePivot.next;        // pivot node is attached to the to-be-moved list
            beforePivot.next = swap;            // to-be-moved list is attached after beforePivot node
            
        }
        
        return virtualHead.next;
        
    }
}
