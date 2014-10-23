public class Solution {
    
    
    
    public List<List<Integer>> threeSum(int[] num) {
        
        if(num.length < 3){
            return new ArrayList<List<Integer>>();
        }
        
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        
        for(int i = 0; i < num.length - 2; ++i){
            int a = num[i];
            int sum = -a;
            int j = i + 1;
            int k = num.length - 1;
            while(j < k){
                int b = num[j];
                int c = num[k];
                if(b + c < sum){
                    ++j;
                }
                else if(b + c > sum){
                    --k;
                }
                else{
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(a);
                    newList.add(b);
                    newList.add(c);
                    ret.add(newList);
                    do{
                        ++j;
                        
                    }while(j < num.length && j < k && num[j] == num[j - 1]);
                    do{
                        --k;
                    }while(k > 0 && k > j && num[k] == num[k + 1]);
                }
            }
            while(i + 1 < num.length - 2 && num[i] == num[i + 1]){
                ++i;
            }
        }
        
        return ret;
    }
}
