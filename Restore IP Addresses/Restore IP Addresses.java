public class Solution {
    
    private boolean isValid(ArrayList<String> res){
        if(res.size() != 4){
            return false;
        }
        
        for(int i = 0; i < 4; ++i){
            char val = res.get(i).charAt(0);
            switch(res.get(i).length()){
                case 0:
                    return false;
                case 1:
                    if((val > '9') || (val < '0')){
                        return false;
                    }
                    break;
                case 2:
                    if((val > '9') || (val <= '0')){
                        return false;
                    }
                    break;
                case 3:
                    if((val > '2') || (val <= '0')){
                        return false;
                    }
                    else if(val == '2'){
                        val = res.get(i).charAt(1);
                        if((val > '5') || (val < '0')){
                            return false;
                        }
                        else if(val == '5'){
                            val = res.get(i).charAt(2);
                            if((val > '5') || (val < '0')){
                                return false;
                            }
                        }
                    }
                    break;
                default:
                    return false;
            }
        }
        
        return true;
    }
    
    private void recur(List<String> ret, ArrayList<String> res, int index, int num, String s){
        if(num > 0){
            for(int i = index; i < s.length(); ++i){
                if((i - index) >= 3){
                    return;
                }
                String subStr = s.substring(index, i + 1);
                res.add(subStr);
                --num;
                recur(ret, res, i + 1, num, s);
                ++num;
                res.remove(res.size() - 1);
            }
            return;
        }
        else{
            if(index == s.length()){        // No more characters left for the fourth number
                return;
            }
            if((s.length() - index) > 3){   // Last number is way tooooo large
                return;
            }
            String subStr = s.substring(index, s.length());
            res.add(subStr);
            
            if(isValid(res)){
                String oneResult = new String();
                for(int j = 0; j < 4; ++j){
                    String tmp = res.get(j);
                    oneResult = oneResult + tmp;
                    if(j != 3){
                        oneResult = oneResult + ".";
                    }
                }
                ret.add(oneResult);
            }
            res.remove(res.size() - 1);
            return;
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        ArrayList<String> res = new ArrayList<String>();
        recur(ret, res, 0, 3, s);
        return ret;
    }
}
