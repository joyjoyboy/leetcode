/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        
        // Duplicate a list
        // Two lists are intertwined
        RandomListNode originalHead = head;
        
        while(head != null){
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }
        
        head = originalHead;
        
        // Traverse original list
        // Complete random pointers in duplicate list
        while(head != null){
            head.next.random = (head.random != null) ? head.random.next : null;
            head = head.next.next;
        }
        
        head = originalHead;
        RandomListNode newHead = head.next;
        RandomListNode duplicateNode = head.next;
        // Decouple original list and duplicate list
        
        while(head != null){
            duplicateNode = head.next;
            if(duplicateNode.next != null){
                head.next = head.next.next;
                duplicateNode.next = duplicateNode.next.next;
            }
            else{
                head.next = null;
            }
            head = head.next;
        }
        
        return newHead;
    }
}
