public class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        
        while(--n > 0){
            StringBuilder ret = new StringBuilder();
            for(int i = 0; i < s.length();){
                char c = s.charAt(i);
                int curr = c - '0';
                int count = 0;
                while(i < s.length() && s.charAt(i) == c){
                    ++count;
                    ++i;
                }
                String n_char = Integer.toString(count);
                ret.append(n_char);
                ret.append(c);
            }
            s = ret.toString();
        }
        return s;
    }
}
