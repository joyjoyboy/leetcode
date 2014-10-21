public class Solution {
    public int findMin(int[] num) {
        // Assume returning 0 for zero-size input array
        if(num.length == 0)     return 0;
        
        int head = 0;
        int end = num.length - 1;
        while(num[head] == num[end]){
            --end;
            if(end < 0){        // Same element populated in array
                return num[head];
            }
        }
        
        while(head <= end){
            while(head < end && num[head] == num[head + 1])     ++head;
            while(end > head && num[end] == num[end - 1])       --end;
            // Size less than 2
            // Choose the smaller one
            if(end - head <= 1){
                return (num[head] < num[end]) ? num[head] : num[end];
            }
            
            int mid = head + end;
            mid /= 2;
            if(num[head] < num[mid]){
                if(num[head] > num[end])
                    head = mid;
                else
                    end = mid;
            }
            else{   // num[head] > num[mid]
                end = mid;
            }
        }
        
        return num[head];
    }
}
