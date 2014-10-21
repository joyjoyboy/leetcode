class Solution {
public:
    bool search(int A[], int n, int target) {
        int l = 0;
        int r = n - 1;
        
        while(l <= r){
            int m = (l + r) / 2;
            //if((A[l] == target) || (A[m] == target) || (A[r] == target))      return true;
            if(A[m] == target)      return true;
            
            if(A[l] < A[m]){
                if((target >= A[l]) && (target < A[m])){        // Choose left half
                    r = m - 1;
                }
                else{
                    l = m + 1;
                }
            }
            else if(A[l] > A[m]){       // A[l] > A[m] indicates pivot in the left half
                if((target > A[m]) && (target <= A[r])){
                    l = m + 1;
                }
                else{
                    r = m - 1;
                }
            }
            else{
                ++l;
            }
        }
        
        return false;
    }
};
