class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        
        // Stupid solution
        /*
        int* C = new int[m + n];
        int a = 0;
        int b = 0;
        if(!n)      return;
        if(!m){
            for(unsigned int i = 0; i < n; ++i){
                A[i] = B[i];
            }
            return;
        }
        for(unsigned int i = 0; i < m + n;){
            if((a < m) && (b < n)){
                if(A[a] > B[b]){
                    C[i] = B[b];
                    b++;
                }
                else{
                    C[i] = A[a];
                    a++;
                }
                ++i;
            }
            else if(a < m){
                C[i] = A[a];
                a++;
                ++i;
            }
            else if(b < n){
                C[i] = B[b];
                b++;
                ++i;
            }
            else{
                break;
            }
        }
        for(unsigned int i = 0; i < m + n; ++i){
            A[i] = C[i];
        }
        delete[] C;
        */
        
        // Smart solution
        // Use no extra memory
        int a = m - 1;
        int b = n - 1;
        int i = a + b + 1;
        while(a >= 0 && b >= 0){
            if(A[a] > B[b])     A[i--] = A[a--];
            else                A[i--] = B[b--];
        }

        while(b >= 0){
            A[i--] = B[b--];
        }
        
    }
};
