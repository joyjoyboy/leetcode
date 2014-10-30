/*
public class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        for(int i = 1; i <= len; ++i){
            Set<Character> find = new HashSet<Character>();
            for(int j = i - 1; j >= 0; --j){
                String word = s.substring(j, i);
                char c = s.charAt(j);
                if(find.contains(c)){
                    // Start next iteration
                    break;
                }
                else{
                    find.add(s.charAt(j));
                    max = Math.max(max, i - j);
                }
            }
        }
        return max;
    }
}
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        // Start typing your Java solution below  
        // DO NOT write main() function  
        int length = s.length();  
        if (length == 0) {  
            return 0;  
        }  
        int [] countTable = new int[256];  
        Arrays.fill(countTable, -1);  
        int max = 1;  
        int start = 0;  
        int end = 1;  
          
        countTable[s.charAt(0)] = 0;  
        while (end < length) {  
            //Has not reached a duplicate char  
            if (countTable[s.charAt(end)] >= start) {  
                start = countTable[s.charAt(end)] + 1;                
            }  
            max = Math.max(max, end - start + 1);  
            countTable[s.charAt(end)] = end;  
            end++;  
        }  
        return max;
        
    }
}
