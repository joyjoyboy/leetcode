public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < numbers.length; ++i){
            if(m.containsKey(numbers[i])){
                List<Integer> l = m.get(numbers[i]);
                l.add(i);
                m.put(numbers[i], l);
            }
            else{
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                m.put(numbers[i], l);
            }
            //if(i != 0 && prev == numbers[i])    duplicate.add(numbers[i]);
        }
        
        Arrays.sort(numbers);
        int index1 = 0;
        int index2 = numbers.length - 1;
        int[] res = new int[2];
        while(index1 < index2){
            int a = numbers[index1];
            int b = numbers[index2];
            if(a + b == target){
                int ret1 = m.get(a).get(0);
                int ret2 = m.get(b).get(0);
                
                if(ret1 < ret2){
                    res[0] = ret1 + 1;
                    res[1] = ret2 + 1;
                }
                else if(ret1 > ret2){
                    res[0] = ret2 + 1;
                    res[1] = ret1 + 1;
                }
                else{
                    ret2 = m.get(a).get(1);
                    res[0] = ret1 + 1;
                    res[1] = ret2 + 1;
                }
                return res;
            }
            else if(a + b < target){
                ++index1;
            }
            else{
                --index2;
            }
        }
        
        return res;
    }
}
