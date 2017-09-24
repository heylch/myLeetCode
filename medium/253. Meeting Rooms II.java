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