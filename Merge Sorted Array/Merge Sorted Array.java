public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int aIndex = m - 1;
        int bIndex = n - 1;
        for(int i = m + n - 1; i >= 0; --i){
            if(aIndex >= 0 && bIndex >= 0){
                if(A[aIndex] >= B[bIndex]){
                    A[i] = A[aIndex];
                    --aIndex;
                }
                else{
                    A[i] = B[bIndex];
                    --bIndex;
                }
            }
            else if(aIndex >= 0){
                A[i] = A[aIndex];
                --aIndex;
            }
            else if(bIndex >= 0){
                A[i] = B[bIndex];
                --bIndex;
            }
            else{
                break;
            }
        }
        
        return;
    }
}
