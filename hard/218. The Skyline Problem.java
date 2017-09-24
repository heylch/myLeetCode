class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> point = new ArrayList<>();
        for(int[] b:buildings) {
            point.add(new int[]{b[0], -b[2]});
            point.add(new int[]{b[1], b[2]});
        }
        Collections.sort(point, (a, b) -> {
                if(a[0] != b[0]) 
                    return a[0] - b[0];
                return a[1] - b[1];
        });
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
        heap.offer(0);
        int prev = 0;
        for(int[] p:point) {
            if(p[1] < 0) {
                heap.offer(-p[1]);
            } else {
                heap.remove(p[1]);
            }
            int cur = heap.peek();
            if(prev != cur) {
                result.add(new int[]{p[0], cur});
                prev = cur;
            }
        }
        return result;
        }
}