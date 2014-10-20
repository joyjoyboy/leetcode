# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
        head = ListNode(0)
        l = head;
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                l.next = l1
                l = l1
                l1 = l1.next
            else:
                l.next = l2
                l = l2
                l2 = l2.next
        if l1 is not None:
            l.next = l1
        else:
            l.next = l2
        return head.next
