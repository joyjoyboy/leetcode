public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        String word = new String();
        for(int i = 0; i < len; ){
            char c = s.charAt(i);
            if(c == ' '){
                do{
                    ++i;
                    if(i == len){
                        break;
                    }
                }while(s.charAt(i) == ' ');
                if(i == len){
                    return word.length();
                }
                else{
                    word = new String();
                }
            }
            else{
                word = word + c;
                ++i;
            }
        }
        return word.length();
    }
}
