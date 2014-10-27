class Solution {
public:
    int sqrt(int x) {
        if(!x || (x == 1)){
            return x;
        }
        
        double x0 = 1.0;
        double x1 = (double)x / x0 + x0;
        x1 /= 2;
        while(abs(x1 - x0) >= 1){
            x0 = x1;
            x1 = (double)x / x0 + x0;
            x1 /= 2;
        }
        return x1;
    }
};
