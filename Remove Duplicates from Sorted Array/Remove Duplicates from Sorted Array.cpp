class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(!n || (n == 1))  return n;
        
        int mark = 0;
        for(unsigned int i = 1; i < n; ++i){
            if(A[mark] != A[i]){
                ++mark;
                A[mark] = A[i];
            }
        }
        
        return mark + 1;
    }
};
