public class Solution {
    public int sqrt(int x) {
        double x0 = 0;
        double x1 = 1;
        
        while(Math.abs(x1 - x0) >= 1){
            x0 = x1;
            x1 = (x1 + x / x1) / 2;
        }
        
        return (int)Math.floor(x1);
    }
}
