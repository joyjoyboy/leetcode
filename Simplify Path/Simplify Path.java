public class Solution {
    public String simplifyPath(String path) {
        String[] elements = path.split("/");
        List<String> res = new ArrayList<String>();
        
        for(String str : elements){
            if(str.equals(".") || str.equals(""))         continue;
            else if(str.equals("..")){
                if(!res.isEmpty()){
                    res.remove(res.size() - 1);
                }
            }
            else{
                res.add(str);
            }
        }
        
        StringBuilder ret = new StringBuilder();
        
        for(String str : res){
            ret.append("/");
            ret.append(str);
        }
        
        if(ret.toString().equals(""))       ret.append("/");
        
        return ret.toString();
    }
}
