class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        res = 0
        for i in A:
            res = res ^ i
        return res
