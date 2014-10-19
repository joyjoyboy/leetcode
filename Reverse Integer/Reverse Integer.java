public class Solution {
    public int reverse(int x) {
        boolean sign = true;
        if(x < 0){
            sign = false;
            x = -x;
        }
        
        int res = 0;
        while(x != 0){
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        
        if(!sign)
            res = -res;
            
        return res;
    }
}
