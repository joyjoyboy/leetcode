class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        slist = s.split(' ')
        slist = [x for x in slist if len(x) > 0]
        return ' '.join(reversed(slist))
