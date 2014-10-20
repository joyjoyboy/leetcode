public class Solution {
    
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> element = new ArrayList<Integer>();
        
        if(num.length == 0){
            return res;
        }
        
        element.add(num[0]);
        res.add(element);
        
        for(int i = 1; i < num.length; ++i){
            List<List<Integer>> newRes = new ArrayList<List<Integer>>();
            for(List<Integer> list : res){
                for(int j = 0; j < list.size(); ++j){
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(j, num[i]);
                    newRes.add(newList);
                }
                List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(num[i]);
                newRes.add(newList);
            }
            res = newRes;
        }
        
        return res;
    }
}
