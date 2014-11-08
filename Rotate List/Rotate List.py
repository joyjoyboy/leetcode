# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def rotateRight(self, head, k):
        
        if head == None:
            return None
        
        temp = head
        for i in xrange(0, k):
            if temp.next == None:
                temp = head
            else:
                temp = temp.next
                
        newLast = head
        while temp.next != None:
            temp = temp.next
            newLast = newLast.next
            
        temp.next = head
        newHead = newLast.next
        newLast.next = None
        return newHead
