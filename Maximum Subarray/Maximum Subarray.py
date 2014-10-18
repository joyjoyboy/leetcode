class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxSubArray(self, A):
        if A is None or len(A) == 0:
            return 0
        maxVal = A[0]
        accu = A[0];
        if A[0] < 0:
            accu = 0
        
        for i in xrange(1, len(A)):
            if A[i] < 0:
                maxVal = max(maxVal, A[i])
                accu = accu + A[i]
                if accu < 0:
                    accu = 0
            else:
                accu = accu + A[i]
                maxVal = max(maxVal, accu)
                
        return maxVal
