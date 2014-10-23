public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();
        
        // Loop n times
        while(rowIndex-- >= 0){
            if(ret.isEmpty()){
                ret.add(1);
            }
            else{
                for(int i = 0; i < ret.size() - 1; ++i){
                    ret.set(i, ret.get(i) + ret.get(i + 1));
                }
                ret.add(0, 1);
                ret.remove(ret.size() - 1);
                ret.add(1);
            }
        }
        
        return ret;
    }
}
