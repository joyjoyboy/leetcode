# Use dp to solve this problem
class Solution:
    # @return a boolean
    def isMatch(self, s, p):
        
        # dimension 1: p; dimension2: s
        dp = [[False for i in xrange(0, len(s) + 1)] for i in xrange(0, len(p) + 1)]
        dp[0][0] = True
        
        for i in xrange(1, len(p) + 1):
            if i >= 2 and p[i - 1] == '*':
                dp[i][0] = dp[i - 2][0]
                
        for i in xrange(1, len(s) + 1):
            for j in xrange(1, len(p) + 1):
                if p[j - 1] == '*':
                    # dp[j - 1][i]: originally match (w/o the asterisk)
                    # dp[j - 2][i]: match when p[i - 1] is discarded
                    # dp[j][i - 1]: match when p[j - 2] == s[i - 1]
                    dp[j][i] = dp[j - 1][i] or dp[j - 2][i] or (dp[j][i - 1] and (s[i - 1] == p[j - 2] or p[j - 2] == '.'))
                elif p[j - 1] == '.':
                    # matches one character
                    dp[j][i] = dp[j - 1][i - 1]
                else:
                    # s[i] == p[i]
                    dp[j][i] = (dp[j - 1][i - 1] and p[j - 1] == s[i - 1])
                    
        return dp[len(p)][len(s)]
