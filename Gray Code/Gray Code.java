public class Solution {
    public List<Integer> grayCode(int n) {
        if(n == 0){
            List<Integer> ret = new ArrayList<Integer>();
            ret.add(0);
            return ret;
        }
        else{
            List<Integer> prev = grayCode(n - 1);
            List<Integer> ret = new ArrayList<Integer>(prev);
            int mask = 1 << (n - 1);
            for(int i = prev.size() - 1; i >= 0; --i){
                int newElement = prev.get(i) | mask;
                ret.add(newElement);
            }
            return ret;
        }
    }
}
