class Solution {
public:
    double pow(double x, int n) {

        if(!n)              return 1;
        if(n < 0){
            x = 1.0 / x;
            n = -n;
        }
        double res;
        if(n % 2){
            res = pow(x, (n - 1) / 2);
            res *= res;
            res *= x;
        }
        else{
            res = pow(x, n / 2);
            res *= res;
        }
        return res;
    }
};
