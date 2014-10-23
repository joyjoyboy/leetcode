public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(n < k || n == 0 || k == 0)       return ret;
        
        
        if(k == 1){
            for(int i = 1; i <= n; ++i){
                List<Integer> element = new ArrayList<Integer>();
                element.add(i);
                ret.add(element);
            }
        }
        else{
            List<List<Integer>> prev = combine(n - 1, k - 1);
            for(List<Integer> l : prev){
                int last = l.get(k - 2);
                for(int i = last + 1; i <= n; ++i){
                    List<Integer> newElement = new ArrayList(l);
                    newElement.add(i);
                    ret.add(newElement);
                }
            }
        }
        
        return ret;
    }
}
