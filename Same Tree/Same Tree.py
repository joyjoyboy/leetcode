# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param p, a tree node
    # @param q, a tree node
    # @return a boolean
    def isSameTree(self, p, q):
        if(p == None):
            if(q != None):
                return False
            else:
                return True
        elif(q == None):
            if(p != None):
                return False
            else:
                return True
        else:
            return (self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right) and (p.val == q.val))
            
