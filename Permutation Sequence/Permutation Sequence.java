public class Solution {
    
    private void fac(int n, List<Integer> list){
        if(n == 1)        list.add(1);
        else{
            fac(n - 1, list);
            int prev = list.get(n - 2);
            int curr = prev * n;
            list.add(curr);
        }
    }
    
    public String getPermutation(int n, int k) {
        if(n == 0){
            return new String();
        }
        else if(n == 1){
            return new String("1");
        }
        
        List<Integer> f = new ArrayList<Integer>();
        fac(n - 1, f);
        
        List<Integer> allnum = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i){
            allnum.add(i + 1);
        }
        
        int num = n - 2;
        long x = k - 1;
        long index = x / f.get(num);
        char[] ret = new char[n];
        int count = 0;
        while(count < n){
            ret[count] = (char)('0'+allnum.get((int)(index)).intValue());
            allnum.remove((int)index);
            ++count;
            x = x % f.get(num);
            --num;
            if(num < 0)        ++num;
            index = x / f.get(num);
        }
        
        return String.valueOf(ret);
    }
}
