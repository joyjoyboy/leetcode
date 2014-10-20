public class Solution {
    public int findMin(int[] num) {
        int start = 0;
        int end = num.length - 1;
        while(start < end){
            int mid = start + end;
            mid /= 2;
            if(end - start == 0){
                return num[start];
            }
            else if(end - start == 1){
                return Math.min(num[start], num[start + 1]);
            }
            else{
                if(num[start] < num[mid]){
                    if(num[mid] < num[end])
                        return num[start];
                    else
                        start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        
        return num[start];
    }
}
