// PriorityQueue
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        Queue<Interval> heap = new PriorityQueue<Interval>((a,b)->(a.end - b.end));
        Arrays.sort(intervals, (a,b) -> (a.start - b.start));
        int result = 1;
        heap.offer(intervals[0]);
        for(int i=1; i < intervals.length; i++){
            if(intervals[i].start >= heap.peek().end){
                heap.poll();
            }
            else{
                result++;
            }
            heap.offer(intervals[i]);
        }
        return result;
    }
}

// two arrays sort
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] end = new int[intervals.length];
        int[] start = new int[intervals.length];
        for(int i=0; i < intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        int result =0;
        int localmax = 0;
        while(i < intervals.length && j < intervals.length){
            if(start[i] < end[j]){
                result++;
            }
                
            else
                j++;
            i++;
        }
        return result;
    }
}