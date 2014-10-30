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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        
        ListNode head = l1;
        ListNode ptr = l1;
        while((l1 != null) && (l2 != null)){
            l1.val = l1.val + l2.val + carry;
            if(l1.val > 9){
                l1.val = l1.val % 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ptr = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            l1.val = l1.val + carry;
            if(l1.val > 9){
                l1.val = l1.val % 10;
                carry = 1;
            }
            else{
                carry = 0;
            }
            ptr = l1;
            l1 = l1.next;
        }
        if(l2 != null){
            ptr.next = l2;
            do{
                l2.val = l2.val + carry;
                if(l2.val > 9){
                    l2.val = l2.val % 10;
                    carry = 1;
                }
                else{
                    carry = 0;
                }
                ptr = l2;
                l2 = l2.next;
            }while(l2 != null);
        }
        if(carry != 0){
            ListNode newNode = new ListNode(1);
            ptr.next = newNode;
        }
        
        return head;
    }
}
