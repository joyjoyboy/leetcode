class Solution {
public:
    int removeElement(int A[], int n, int elem) {

        for(unsigned int i = 0; i < n;){
            // Find element to be removed
            if(A[i] == elem){
                // Remove element at index i
                // Overwrite A[i] with A[i + 1] and so on
                for(unsigned int j = i + 1; j < n; ++j){
                    A[j - 1] = A[j];
                }
                // Length is shortened
                n--;
            }
            // Move index
            else{
                ++i;
            }
        }
        return n;
    }
};
