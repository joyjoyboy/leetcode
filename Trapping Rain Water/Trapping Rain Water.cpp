class Solution {
public:
    int trap(int A[], int n) {
        if(!n || (n == 1) || (n == 2))      return 0;
        
        int* maxLeft = new int[n];
        int* maxRight = new int[n];
        
        for(unsigned int i = 0; i < n; ++i){
            maxLeft[i] = 0;
            maxRight[i] = 0;
        }
        
        for(unsigned int i = 1; i < n; ++i){
            maxLeft[i] = (maxLeft[i - 1] > A[i - 1]) ? maxLeft[i - 1] : A[i - 1];
        }
        for(int i = n - 2; i >= 0; --i){
            maxRight[i] = (maxRight[i + 1] > A[i + 1]) ? maxRight[i + 1] : A[i + 1];
        }
        int sum = 0;
        for(unsigned int i = 0; i < n; ++i){
            int diff = ((maxLeft[i] < maxRight[i]) ? maxLeft[i] : maxRight[i]) - A[i];
            if(diff > 0){
                sum += diff;
            }
        }
        return sum;
    }
};
