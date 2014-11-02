class Solution:
    # @param path, a string
    # @return a string
    def simplifyPath(self, path):
        if path is None:
            return None
        
        List = path.split('/')
        stk = []
        
        for i in List:
            if i == '' or i == '.':
                continue
            elif i == '..':
                if stk:
                    stk.pop()
            else:
                stk.append(i)
                
        return '/' + '/'.join(stk)
                    
