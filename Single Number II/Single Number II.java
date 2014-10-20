public class Solution {
    public int singleNumber(int[] A) {
        // Bits that appear only one time
        // Iteratively take 'xor' operation on every number (left numbers that appear odd times)
        // If a number appears three times, it is removed from ones
        int ones = 0;
        // Bits that appear at least twice
        // Bits that appear more than twice (i.e. greater than or equal to 3) will be removed
        int twos = 0;
        // Bits that appear three times
        // Computed by taking 'and' operation on ones and twos
        int threes = 0;
        for(int i = 0; i < A.length; ++i){
            // Update twos first
            // Use previous ones. Compare with current number
            // Take the same bits (appears at least twice)
            twos = twos | (ones & A[i]);
            // Update ones
            // XOR itself. Bits that appears even times will be removed
            ones = ones ^ A[i];
            // Update threes
            // Threes can be computed from ones and twos (take AND result)
            threes = ones & twos;
            // Remove bits that appear three times from ones and twos
            int mask = ~threes;
            ones = ones & mask;
            twos = twos & mask;
        }
        
        return ones;
    }
}
