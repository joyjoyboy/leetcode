public class Solution {
    
    private boolean isPalindrome(String s){
        for(int i = 0; i <= s.length() / 2; ++i){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    
    private void palindrome(List<List<String>> result, List<String> solution, String s, int index){
        
        if(index == s.length()){
            result.add(new ArrayList<String>(solution));
            return;
        }
        else{
            // Get the first available palindrome string
            for(int i = index; i < s.length(); ++i){
                String sub = s.substring(index, i + 1);
                if(isPalindrome(sub)){
                    solution.add(sub);
                    palindrome(result, solution, s, i + 1);
                    solution.remove(solution.size() - 1);
                }
            }
        }
        
        return;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> solution = new ArrayList<String>();
        
        palindrome(ret, solution, s, 0);
        
        return ret;
    }
}
