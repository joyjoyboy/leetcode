public class Solution {
    public int atoi(String str) {
        char[] c = str.toCharArray();
        int index = 0;
        while(index < c.length){
            if(c[index] == ' '){
                index++;
            }
            else{
                break;
            }
        }
        if(index == c.length){
            return 0;
        }
        
        boolean sign = true;
        if(c[index] == '-'){
            sign = false;
            index++;
        }
        else if(c[index] == '+'){
            ++index;
        }
        else if((c[index] > '9') || (c[index] < '0')){
            return 0;
        }
        
        if(index == c.length){
            return 0;
        }
        
        int sum = 0;
        
        while(index < c.length){
            
            if((c[index] > '9') || (c[index] < '0')){
                break;
            }
            
            if(sum > Integer.MAX_VALUE / 10){
                return (sign) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum *= 10;
            if(sum > Integer.MAX_VALUE - (c[index] - '0')){
                return (sign) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum += (c[index] - '0');
            
            ++index;
        }
        
        if(!sign){
            sum = -sum;
        }
        
        return sum;
    }
}
