class Solution:
    
    def helper(self, n, left, right, string, result):
        if left == n and right == n:
            result.append(string)
            return
        
        in1 = string
        in2 = string
        
        if right < left:
            in1 = in1 + ')'
            self.helper(n, left, right + 1, in1, result)
        
        if left < n:
            in2 = in2 + '('
            self.helper(n, left + 1, right, in2, result)
            
    # @param an integer
    # @return a list of string
    def generateParenthesis(self, n):
        result = list()
        self.helper(n, 0, 0, "", result)
        return result
