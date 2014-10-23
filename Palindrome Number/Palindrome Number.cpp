class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0)   return false;
        int tmp = x;
        int counter = 0;
        while(tmp){
            ++counter;
            tmp /= 10;
        }
        
        while(x){
            int mask = 0;
            int count = 0;
            while(count++ < counter){
                if(mask)    mask *= 10;
                else        mask = 1;
            }
            
            int MSB = x / mask;
            int LSB = x % 10;
            if(MSB != LSB)      return false;
            x -= MSB * mask;
            if(!x)      break;
            x /= 10;
            counter -= 2;
        }
        return true;
    }
};
