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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode sorted = head;
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        fakeHead.next = head;
        ListNode target = sorted.next;
        
        while(target != null){
            ListNode nextTarget = target.next;
            ListNode prev = fakeHead;
            ListNode n = fakeHead.next;
            while(n != target){
                if(target.val > n.val){
                    prev = n;
                    n = n.next;
                }
                else{
                    prev.next = target;
                    target.next = n;
                    sorted.next = nextTarget;
                    break;
                }
            }
            if(n == target)     sorted = target;
            target = nextTarget;
        }
        return fakeHead.next;
    }
}
