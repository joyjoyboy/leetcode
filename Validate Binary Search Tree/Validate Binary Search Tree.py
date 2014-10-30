# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    # @param root, a tree node
    # @return a boolean
    def helper(self, root, minVal, maxVal):
        if root is None:
            return True
        elif root.val >= maxVal or root.val <= minVal:
            return False
        else:
            return self.helper(root.left, minVal, root.val) and self.helper(root.right, root.val, maxVal)
    
    def isValidBST(self, root):
        return self.helper(root, -2147483647, 2147483647)
