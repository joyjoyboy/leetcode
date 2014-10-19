class Solution:
    # @return an integer
    def numTrees(self, n):
        if(n == 0):
            return 1
        elif(n == 1):
            return 1
        else:
            result = 0
            for i in range(n):
                result += self.numTrees(i) * self.numTrees(n - i - 1)
            return result
        
