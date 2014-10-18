class Solution {
public:
    int maxSubArray(int A[], int n) {
        // Empty array
        if(!n)  return 0;
        
        // Only one element
        int max = A[0];
        int sum = 0;
        if(n == 1)  return A[0];
        
        // Traverse the array
        for(unsigned int i = 0; i < n; ++i){
            sum += A[i];
            max = (max > sum) ? max : sum;
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
};
