class Solution {
public:

    int fromAtoB(int a, int b){
        if(!a || !b)      return 1;
        
        long res = 1;

        // Prime number table
        // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
        // 31, 37, 41, 43, 47, 53, 59, 61, 67, 71
        // Should be enough
        // WTF

        unsigned int pt[20] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};
        unsigned int count[20] = {0};
        
        int large = (a >= b) ? a : b;
        int small = (a < b) ? a : b;
        int overall = a + b;
        
        int iter = large + 1;
        while(iter <= overall){
            int temp = iter;
            for(unsigned int i = 0; i < 20; ++i){
                unsigned int factor = pt[i];
                while(!(temp % factor)){
                    count[i]++;
                    temp /= factor;
                }
            }
            ++iter;
        }
        
        iter = small;
        while(iter >= 1){
            int temp = iter;
            for(unsigned int i = 0; i < 20; ++i){
                unsigned int factor = pt[i];
                while(!(temp % factor)){
                    count[i]--;
                    temp /= factor;
                }
            }
            --iter;
        }
        
        for(unsigned int i = 0; i < 20; ++i){
            unsigned int factor = pt[i];
            while(count[i]){
                count[i]--;
                res *= factor;
            }
        }
        
        return (int)res;
    }

    int climbStairs(int n) {
        std::vector<std::pair<int, int> >   res;
        int a = 0;
        int b = 0;
        int possibilities = 0;
		// Compute C(n, m)
		// Involves lots of computation
		// Which will very likely cause overflow
		// Therefore a prime number table is introduced
		// Which could be the factors of numbers small enough
		// Sort of hacking lol
        while(a <= n / 2){
            b = n - 2 * a;
            possibilities += fromAtoB(a, b);
            ++a;
        }
        
        return possibilities;
    }
};
