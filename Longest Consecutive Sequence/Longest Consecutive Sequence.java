public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> all = new HashSet<Integer>();
        int maxLen = 0;
        
        for(int i = 0; i < num.length; ++i)         all.add(num[i]);
        
        for(int i = 0; i < num.length; ++i){
            int val = num[i];
            if(visited.contains(val))       continue;
            
            visited.add(val);
            int valLeft = val - 1;
            int valRight = val + 1;
            int count = 1;
            while(all.contains(valLeft)){
                visited.add(valLeft);
                --valLeft;
                ++count;
            }
            while(all.contains(valRight)){
                visited.add(valRight);
                ++valRight;
                ++count;
            }
            
            maxLen = Math.max(maxLen, count);
        }
        
        return maxLen;
    }
}
