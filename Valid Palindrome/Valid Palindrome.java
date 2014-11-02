public class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toLowerCase().toCharArray();
        int front = 0;
        int end = str.length - 1;
        while(front < end){
            while(front < str.length && !((str[front] >= 'a' && str[front] <= 'z') || (str[front] >= '0' && str[front] <= '9')))     ++front;
            if(front > end)     return true;
            while(end >= 0 && !((str[end] >= 'a' && str[end] <= 'z') || (str[end] >= '0' && str[end] <= '9')))     --end;
            if(front > end)     return true;
            if(str[front] != str[end])          return false;
            ++front;
            --end;
        }
        return true;
    }
}
