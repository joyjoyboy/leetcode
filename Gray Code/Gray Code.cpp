class Solution {
public:
    vector<int> grayCode(int n) {
        std::vector<int> container;

        
        // Must start from 0
        container.push_back(0);
        // 0 size makes no sense
        // However, the required answer is "0"
        if(!n)      return container;
        
        container.push_back(1);
        // size 1 is the starting point of all the following operations
        if(n == 1)  return container;

        // Trick: n-bit (n > 1) Gray Code could be deduced from (n - 1)-bit Gray Code
        // Just reverse all the (n - 1)-bit Gray Code, and put a "1" in front of them
        for(int i = 1; i < n; ++i){
            int highest_bit = 1 << i;
            int count = highest_bit - 1;
            for(int k = count; k >= 0; --k){
                container.push_back(highest_bit + container[k]);
            }
        }
        
        return container;

    }
};
