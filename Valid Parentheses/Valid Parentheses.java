public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        char[] pars = s.toCharArray();
        for(char c : pars){
            switch(c){
                case '(':
                    stk.push(c);
                    break;
                case ')':
                    if(stk.empty() || stk.peek() != '('){
                        return false;
                    }
                    stk.pop();
                    break;
                case '[':
                    stk.push(c);
                    break;
                case ']':
                    if(stk.empty() || stk.peek() != '['){
                        return false;
                    }
                    stk.pop();
                    break;
                case '{':
                    stk.push(c);
                    break;
                case '}':
                    if(stk.empty() || stk.peek() != '{'){
                        return false;
                    }
                    stk.pop();
                    break;
                default:
                    return false;
            }
        }
        
        return stk.empty();
    }
}
