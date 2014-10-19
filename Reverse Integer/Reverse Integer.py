class Solution:
    # @return an integer
    def reverse(self, x):
        l = len(str(x))
        sign = True
        if(x < 0):
            l -= 1
            sign = False
            x = -x
        
        res = 0
        while(x != 0):
            res *= 10
            res += x % 10
            x /= 10
        
        if(sign == False):
            res = -res
        
        return res
