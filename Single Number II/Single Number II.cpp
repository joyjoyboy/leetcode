class Solution {
public:
    int singleNumber(int A[], int n) {
        // Compute every bit's occurrance
#if 0
        unsigned int count[32];
        for(unsigned int i = 0; i < 32; ++i){
            count[i] = 0;
        }
        for(unsigned int i = 0; i < 32; ++i){
            for(unsigned int j = 0; j < n; ++j){
                count[i] += ((A[j] >> i) & 1);
                count[i] %= 3;
            }
        }
        int res = 0;
        for(unsigned int i = 0; i < 32; ++i){
            res += count[i] * (1 << i);
        }
        return res;
#endif        
        // Use integers to record occurrance of every bit
        // Evil bit level hack
        int once = 0;
        int twice = 0;
        int thrice = 0;
        for(unsigned int i = 0; i < n; ++i){
            twice |= once & A[i];
            once = once ^ A[i];
            thrice = once & twice;
            once &= ~thrice;
            twice &= ~thrice;
        }
        return once;
    }
};
