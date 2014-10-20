class Solution {
public:
    void sortColors(int A[], int n) {
        unsigned int red_count = 0;
        unsigned int white_count = 0;
        unsigned int blue_count = 0;
        
        // red: 0
        // white: 1
        // blue: 2
        for(unsigned int i = 0; i < n; ++i)
            if(A[i] == 0)   ++red_count;
            else if(A[i] == 1)      ++white_count;
            else if(A[i] == 2)      ++blue_count;
            
        for(unsigned int i = 0; i < n; ++i){
            if(i < red_count){
                A[i] = 0;
            }
            else if(i < red_count + white_count){
                A[i] = 1;
            }
            else if(i < red_count + white_count + blue_count){
                A[i] = 2;
            }
        }
    }
};
