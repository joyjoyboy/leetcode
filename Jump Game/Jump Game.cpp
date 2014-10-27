class Solution {
public:
/*
    bool recur(int A[], int n, int start){
        if(start >= n)      return true;
        
        for(unsigned int i = 1; i <= A[start]; ++i){
            if((start + i) >= n){
                return true;
            }
            else{
                if(recur(A, n, start + i)){
                    return true;
                }
            }
        }
        return false;
    }
*/    
    bool canJump(int A[], int n) {
        if(!n)      return false;
        if(n == 1)  return true;
        
//        return recur(A, n, 0);
        
        int start = A[0];
        int max = start;
        int i = 0;
        while(i < n - 1){
            start = A[i] + i;
            max = (max > start) ? max : start;
            if(max < i + 1){
                return false;
            }
            if(max >= n - 1){
                return true;
            }
            ++i;
        }
        return true;
    }
};
