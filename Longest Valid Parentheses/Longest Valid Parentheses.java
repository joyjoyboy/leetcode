public class Solution {
    public int longestValidParentheses(String s) {
        char[] c = s.toCharArray();
        
        int max = 0;
        int accu = 0;
        int numOfPairs = 0;
        for(int i = 0; i < c.length; ++i){
            switch(c[i]){
                case '(':
                    ++numOfPairs;
                    break;
                case ')':
                    if(numOfPairs == 0){
                        c[i] = '.';
                    }
                    else{
                        --numOfPairs;
                    }
                    break;
            }
        }
        
        numOfPairs = 0;
        for(int i = c.length - 1; i >= 0; --i){
            switch(c[i]){
                case ')':
                    ++numOfPairs;
                    ++accu;
                    break;
                case '(':
                    if(numOfPairs == 0){
                        c[i] = '.';
                        accu = 0;
                    }
                    else{
                        --numOfPairs;
                        ++accu;
                    }
                    break;
                case '.':
                    accu = 0;
                    break;
            }
            max = Math.max(max, accu);
        }
        
        return max;
    }
}
