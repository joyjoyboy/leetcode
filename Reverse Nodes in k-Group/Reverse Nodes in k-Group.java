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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if((k == 0) || (k == 1)){
            return head;
        }
        
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode fastPtr = head;
        ListNode headPtr = head;
        int count = 1;
        
        ListNode beforeHead = fakeHead;
        while(fastPtr != null){
        
            while(fastPtr != null){
                fastPtr = fastPtr.next;
                ++count;
                if(count == k){
                    break;
                }
            }
            
            if(fastPtr != null){
                ListNode nextHead = fastPtr.next;       // This node the head of the next bucket of nodes
                ListNode currEnd = beforeHead.next;     // currEnd points to the head (soon will be the end) of the current bucket
                ListNode prev = nextHead;               // This node indicates the previous node of every node in current bucket
                while(headPtr != fastPtr){              // Reverse the nodes in current bucket one by one
                    ListNode nextNode = headPtr.next;   // Next node that is going to be modified
                    headPtr.next = prev;                // Points to its previous node
                    prev = headPtr;                     // Update previous node for the next iteration
                    headPtr = nextNode;                 // Start working on the next node
                }
                headPtr.next = prev;                    // The last node in the current bucket is modified
                beforeHead.next = headPtr;              // The last node in the previous bucket points to the new head in current bucket
                beforeHead = currEnd;                   // Current bucket becomes previous one
                headPtr = nextHead;
                fastPtr = nextHead;
            }
            
            count = 1;
        }
        
        return fakeHead.next;
    }
}
