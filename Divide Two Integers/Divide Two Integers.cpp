class Solution {
public:
    int divide(int dividend, int divisor) {
        int res = 0;
        // true: positive
        // false: negative
        bool sign = true;
        
        // Exception
        if(!divisor){
            return 0;
        }
        
        if(((dividend < 0) && (divisor < 0)) || ((dividend >= 0) && (divisor > 0))){
            sign = true;
        }
        else{
            sign = false;
        }
        
        // On x86 platform, int == long int (32-bit)
        // long long int (64-bit) is required when the dividend is INT_MAX
        // Note: type cast must be performed in abs()
        // God damn it I hate abs() function
        // It SHOULD support long long input but it did not work on my computer
        long long op1 = abs((long long)dividend);
        long long op2 = abs((long long)divisor);
        
        long long multipleOf2 = 1;    // 2^0 = 1
        while(op2 < op1){
            op2 = op2 << 1;
            multipleOf2 = multipleOf2 << 1;
        }
        
        while(multipleOf2 > 0){
            if(op1 >= op2){
                res += multipleOf2;
                op1 -= op2;
            }
            else{
                // What else needs to be done?
            }
            op2 = op2 >> 1;
            multipleOf2 = multipleOf2 >> 1;
        }
        
        res = (sign) ? res : (-res);
        
        return res;
        
    }

};
