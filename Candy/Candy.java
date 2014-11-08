public class Solution {
    public int candy(int[] ratings) {
        int total = 1;
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        int minimum = 1;
        
        for(int i = 1; i < ratings.length; ++i){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
                total += candies[i];
            }
            else{
                candies[i] = 1;
                ++total;
            }
        }
        
        for(int i = ratings.length - 2; i >= 0; --i){
            if(ratings[i + 1] < ratings[i]){
                int prev = candies[i];
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                total += (candies[i] - prev);
            }
        }
        
        return total;
    }
}
