class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        for(int i = 0; i < n; ){
            if(A[i] != i + 1 && A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]){
                int targetIndex = A[i] - 1;
                int temp = A[i];
                A[i] = A[targetIndex];
                A[targetIndex] = temp;
            }
            else{
                ++i;
            }
        }
        for(int i = 0; i < n; ++i){
            if(A[i] != i + 1)       return i + 1;
        }
        return n + 1;
    }
};
