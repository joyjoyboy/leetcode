public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)               return false;
        else if(x == 0)         return true;
        
        long lMask = 1;
        long rMask = 1;
        long temp = x;
        
        while(temp > 0){
            temp /= 10;
            lMask *= 10;
        }
        lMask /= 10;
        
        while(lMask > rMask){
            long msb = (x / lMask) % 10;
            long lsb = (x % (rMask * 10)) / rMask;
            if(msb != lsb){
                return false;
            }
            lMask /= 10;
            rMask *= 10;
        }
        
        return true;
    }
}
