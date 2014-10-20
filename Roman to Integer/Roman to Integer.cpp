class Solution {
public:
    int romanToInt(string s) {
        int sum = 0;
        for(unsigned int i = 0; i < s.length(); ++i){
            char digit = s[i];
            switch(digit){
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    if(i < s.length() - 1){     // Make sure that 'C' is not LSB
                        if((s[i + 1] == 'D') || (s[i + 1] == 'M')){
                            sum -= 100;
                        }
                        else{
                            sum += 100;
                        }
                    }
                    else{
                        sum += 100;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    if(i < s.length() - 1){
                        if((s[i + 1] == 'L') || (s[i + 1] == 'C')){
                            sum -= 10;
                        }
                        else{
                            sum += 10;
                        }
                    }
                    else{
                        sum += 10;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    if(i < s.length() - 1){
                        if((s[i + 1] == 'V') || (s[i + 1] == 'X')){
                            sum--;
                        }
                        else{
                            sum++;
                        }
                    }
                    else{
                        sum++;
                    }
                    break;
                default:
                
                    break;
            }
        }
        return sum;
    }
};
