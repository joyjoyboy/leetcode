public class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> res = new Stack<Integer>();
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; --i){
            int num = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
            res.push(num);
        }
        if(carry != 0){
            res.push(carry);
        }
        
        int len = res.size();
        int[] ret = new int[len];
        for(int i = 0; i < len; ++i){
            ret[i] = res.pop();
        }
        
        return ret;
    }
}
