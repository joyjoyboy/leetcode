class Solution {
public:
    int reverse(int x) {
        std::list<int> s;
        bool sign = true;
        if(x < 0){
            sign = false;
            x *= (-1);
        }
        int n;
        while(x){
            n = x % 10;
            x /= 10;
            s.push_back(n);
        }
        n = 0;
        while(!s.empty()){
            n *= 10;
            n += s.front();
            s.pop_front();
        }
        return (sign) ? n : (n * (-1));
    }
};
