# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a list of lists of integers
    
    def pathSum(self, root, sum):
        if root is None:
            return []
        elif root.left is None and root.right is None:
            if sum == 0:
                return [[root]]
            else:
                return []
        elif root.left is None:
            res = self.pathSum(root.right, sum - root.val)
            return [[root] + item for item in res]
        elif root.right is None:
            res = self.pathSum(root.left, sum - root.val)
            return [[root] + item for item in res]
        else:
            res = self.pathSum(root.left, sum - root.val)
            res.extend(self.pathSum(root.right, sum - root.val))
            return [[root] + item for item in res]
        
        
