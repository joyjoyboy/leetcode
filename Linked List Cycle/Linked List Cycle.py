# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        if head is None or head.next is None:
            return False
        
        slow = head
        fast = head.next
        
        while slow != fast:
            slow = slow.next
            fast = fast.next
            if fast is None:
                return False
            fast = fast.next
            if fast is None:
                return False
        
        if fast is None:
            return False
        else:
            return True
        
