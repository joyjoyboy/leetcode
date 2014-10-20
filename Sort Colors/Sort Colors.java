public class Solution {
    public void sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i = 0; i < A.length; ++i){
            if(A[i] == 0){
                ++red;
            }
            else if(A[i] == 1){
                ++white;
            }
            else if(A[i] == 2){
                ++blue;
            }
        }
        for(int i = 0; i < A.length; ++i){
            if(red > 0){
                A[i] = 0;
                --red;
            }
            else if(white > 0){
                A[i] = 1;
                --white;
            }
            else if(blue > 0){
                A[i] = 2;
                --blue;
            }
        }
        
        return;
    }
}
