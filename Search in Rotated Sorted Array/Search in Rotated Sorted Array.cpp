class Solution {
public:
    int search(int A[], int n, int target) {
        int l = 0;
        int r = n - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(A[m] == target)      return m;       // Found at middle
            //if(A[l] == target)      return l;       // Found at left
            //if(A[r] == target)      return r;       // Found at right
            
            if(A[l] <= A[m]){                        // Pivot is in the right half
                if((target >= A[l]) && (target < A[m])){       // Choose left
                    r = m - 1;
                }
                else{                                           // Choose right
                    l = m + 1;
                }
            }
            else{                                   // Pivot is in the left half
                if((target > A[m]) && (target <= A[r])){       // Choose right
                    l = m + 1;
                }
                else{                                           // Choose left
                    r = m - 1;
                }
            }
        }
        
        return -1;      // Not found
    }
};
