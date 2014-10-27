/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

/*    
    private void Sort(List<Interval> intervals){
        for(int i = 1; i < intervals.size(); ++i){
            for(int j = 0; j < i; ++j){
                if(intervals.get(j).start > intervals.get(i).start){
                    Interval temp = intervals.get(j);
                    intervals.set(j, intervals.get(i));
                    intervals.set(i, temp);
                }
            }
        }
    }
*/    
    public List<Interval> merge(List<Interval> intervals) {
        
        //Sort(intervals);
        
        Comparator<Interval> comparator = new Comparator<Interval>(){
            public int compare(Interval in1, Interval in2){
                return in1.start - in2.start;
            }
        };
        
        Collections.sort(intervals, comparator);
        
        for(int i = 1; i < intervals.size();){
            Interval curr = intervals.get(i);
            Interval prev = intervals.get(i - 1);
            if((curr.start <= prev.end) && (curr.end >= prev.start)){
                prev.start = (prev.start < curr.start) ? prev.start : curr.start;
                prev.end = (prev.end > curr.end) ? prev.end : curr.end;
                intervals.remove(i);
            }
            else{
                ++i;
            }
        }
        return intervals;
    }
}
