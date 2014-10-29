public class Solution {
    public String addBinary(String a, String b) {
        String res = new String();
        boolean carry = false;
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        for(int i = 0; i < Math.max(a.length(), b.length()); ++i){
            char i1 = '0';
            if(i < a.length()){
                i1 = a.charAt(i);
            }
            char i2 = '0';
            if(i < b.length()){
                i2 = b.charAt(i);
            }
            
            if(i1 == '1' && i2 == '1'){
                if(carry)       res = res + '1';
                else            res = res + '0';
                carry = true;
            }
            else if(i1 == '1' || i2 == '1'){
                if(carry){
                    res = res + '0';
                    carry = true;
                }
                else{
                    res = res + '1';
                    carry = false;
                }
            }
            else{
                if(carry)       res = res + '1';
                else            res = res + '0';
                carry = false;
            }
        }
        if(carry)       res = res + '1';
        
        return new StringBuilder(res).reverse().toString();
    }
}
