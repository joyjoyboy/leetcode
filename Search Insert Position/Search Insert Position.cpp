class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        int prev = 0;
        for(int i = 0; i < n; ++i){
            if(target == A[i])  return i;
            else if(!prev && (target < A[0])){
                return 0;
            }
            else if((i == n - 1) && (target > A[i])){
                return n;
            }
            else if((target > A[prev]) && (target < A[i])){
                return i;
            }
            prev = i;
        }
        return n;
    }
};
