public class Solution {
    
    public List<String> anagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
        
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String comp = String.copyValueOf(s);
            if(hash.containsKey(comp)){
                hash.get(comp).add(str);
            }
            else{
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(str);
                hash.put(comp, tempList);
            }
        }
        
        List<String> res = new ArrayList<String>();
        
        for(ArrayList<String> list : hash.values()){
            if(list.size() > 1){
                for(String str : list){
                    res.add(str);
                }
            }
        }
        
        return res;
    }
}
