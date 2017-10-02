class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals.size() == 0)
            return result;
        intervals.sort((i1,i2) -> (i1.start - i2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=1; i < intervals.size(); i++){
            Interval interval = intervals.get(i);
            if(interval.start <= end && interval.end > end){
                end = interval.end;
            }
            else if(interval.start > end){
                Interval newInterval = new Interval(start,end);
                result.add(newInterval);
                start = interval.start;
                end = interval.end;
            }
        }
        Interval lastInterval = new Interval(start,end);
        result.add(lastInterval);
        return result;
    }
}