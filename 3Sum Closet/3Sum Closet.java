public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int min_dist = Integer.MAX_VALUE;
        int res = 0;
        
        Arrays.sort(num);
        
        for(int i = 0; i < num.length - 1; ++i){
            int start = i + 1;
            int end = num.length - 1;
            
            while(start < end){
                int sum = num[start] + num[end];
                int diff = sum + num[i] - target;
                if(diff == 0){
                    return sum + num[i];
                }
                else if(diff < 0){
                    if(Math.abs(min_dist) > Math.abs(diff)){
                        min_dist = diff;
                        res = sum + num[i];
                    }
                    ++start;
                }
                else{
                    if(Math.abs(min_dist) > Math.abs(diff)){
                        min_dist = diff;
                        res = sum + num[i];
                    }
                    --end;
                }
            }
        }
        return res;
    }
}
