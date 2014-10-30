class Solution:
    # @param x, a float
    # @param n, a integer
    # @return a float
    def pow(self, x, n):
        if n == 0:
            return 1
        elif n == 1:
            return x
            
        if n < 0:
            n = -n
            x = 1.0 / x
            
        if n % 2 == 0:
            res = self.pow(x, n / 2)
            return res * res
        else:
            res = self.pow(x, math.floor(n / 2))
            return res * res * x
            
