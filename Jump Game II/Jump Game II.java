public class Solution {
    public int jump(int[] A) {
        int size = A.length;
        if((size == 0) || (size == 1)){
            return 0;
        }
        
        int step = 1;
        int end = 0;
        int start = 0;
        while(end < size){
            
            int newEnd = 0;
            for(int i = start; i <= end; ++i){
                newEnd = (newEnd > A[i] + i) ? newEnd : A[i] + i;
                if(newEnd >= size - 1){
                    return step;
                }
            }
            start = end + 1;
            ++step;
            end = newEnd;
        }
        
        return step;
    }
}
