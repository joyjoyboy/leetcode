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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        
        ListNode headNode = (l1.val < l2.val) ? l1 : l2;
        boolean curr = (l1.val < l2.val) ? false : true;       // false -> l1; true -> l2
        ListNode prev = null;
        while(l1 != null && l2 != null){
            if(!curr){
                if(l1.val < l2.val){
                    prev = l1;
                    l1 = l1.next;
                }
                else{
                    curr = true;
                    prev.next = l2;
                    prev = l2;
                    l2 = l2.next;
                }
            }
            else{
                if(l1.val >= l2.val){
                    prev = l2;
                    l2 = l2.next;
                }
                else{
                    curr = false;
                    prev.next = l1;
                    prev = l1;
                    l1 = l1.next;
                }
            }
        }
        if(l1 == null){
            prev.next = l2;
        }
        else{
            prev.next = l1;
        }
        
        return headNode;
    }
}
