class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(!n)      return 0;
        
        int prev = A[0];
        int ptr = 1;
        int twiceFlag = false;
        int len = n;
        for(unsigned int i = 1; i < n; ++i){
            if(prev == A[i]){
                if(twiceFlag){
                    // ptr ain't moving
                    --len;
                }
                else{
                    twiceFlag = true;
                    A[ptr] = A[i];
                    ++ptr;
                    prev = A[i];
                }
            }
            else{
                twiceFlag = false;
                A[ptr] = A[i];
                ++ptr;
                prev = A[i];
            }
        }
        
        return len;
    }
};
