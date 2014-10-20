class Solution:
    # @return a list of integers
    def grayCode(self, n):
        if n == 0:
            return [0]
        elif n == 1:
            return [0, 1]
        else:
            list = self.grayCode(n - 1)
            newlist = []
            for s in list:
                newlist.append(s)
            for s in reversed(list):
                newlist.append(s + 2**(n - 1))
            return newlist
