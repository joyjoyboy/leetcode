class Solution:
    # @param s, a string
    # @return an integer
    def lengthOfLastWord(self, s):
        for w in reversed(s.split(' ')):
            if len(w) > 0:
                return len(w)
        
        return 0
