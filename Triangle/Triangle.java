public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = new ArrayList(triangle.get(triangle.size() - 1));

        for(int i = triangle.size() - 2; i >= 0; --i){
            for(int j = 0; j <= i; ++j){
                int choice = Math.min(res.get(j), res.get(j + 1));
                res.set(j, triangle.get(i).get(j) + choice);
            }
        }
        
        return res.get(0);
        
    }
}
