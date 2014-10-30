# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        ptr = l1
        head = ptr
        carry = 0
        while l1 is not None and l2 is not None:
            l1.val += l2.val + carry
            if l1.val > 9:
                l1.val %= 10
                carry = 1
            else:
                carry = 0
            ptr = l1
            l1 = l1.next
            l2 = l2.next
            
        if not ptr.next:
            ptr.next = l2
        
        while l1 is not None:
            l1.val += carry
            if l1.val > 9:
                l1.val %= 10
                carry = 1
            else:
                carry = 0
                break
            ptr = l1
            l1 = l1.next
        
        while l2 is not None:
            l2.val += carry
            if l2.val > 9:
                l2.val %= 10
                carry = 1
            else:
                carry = 0
                break
            ptr = l2
            l2 = l2.next
        if carry == 1:
            ptr.next = ListNode(1)
            
        return head
