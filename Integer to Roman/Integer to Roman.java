public class Solution {
    public String intToRoman(int num) {
        Stack<Character> res = new Stack<Character>();
        int bit = 0;
        while(num > 0){
            int numeral = num % 10;
            num /= 10;
            
            if(numeral == 0){
                
            }
            else if(numeral >= 1 && numeral <= 3){
                while(numeral > 0){
                    --numeral;
                    if(bit == 0){
                        res.push('I');
                    }
                    else if(bit == 1){
                        res.push('X');
                    }
                    else if(bit == 2){
                        res.push('C');
                    }
                    else if(bit == 3){
                        res.push('M');
                    }
                }
            }
            else if(numeral == 4){
                if(bit == 0){
                    res.push('V');
                    res.push('I');
                }
                else if(bit == 1){
                    res.push('L');
                    res.push('X');
                }
                else if(bit == 2){
                    res.push('D');
                    res.push('C');
                }
            }
            else if(numeral >= 5 && numeral <= 8){
                while(numeral > 5){
                    --numeral;
                    if(bit == 0){
                        res.push('I');
                    }
                    else if(bit == 1){
                        res.push('X');
                    }
                    else if(bit == 2){
                        res.push('C');
                    }
                }
                if(bit == 0){
                    res.push('V');
                }
                else if(bit == 1){
                    res.push('L');
                }
                else if(bit == 2){
                    res.push('D');
                }
            }
            else if(numeral == 9){
                if(bit == 0){
                    res.push('X');
                    res.push('I');
                }
                else if(bit == 1){
                    res.push('C');
                    res.push('X');
                }
                else if(bit == 2){
                    res.push('M');
                    res.push('C');
                }
            }
            
            ++bit;
        }
        
        char[] str = new char[res.size()];
        int index = 0;
        while(!res.isEmpty()){
            str[index++] = res.pop();
        }
        
        return String.valueOf(str);
    }
}
