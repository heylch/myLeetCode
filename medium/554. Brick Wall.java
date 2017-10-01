class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> crack = new HashMap<Integer, Integer>();
        int max = 0;
        for(int i=0; i < wall.size(); i++){
            List<Integer> layer = wall.get(i);
            int sum = 0;
            for(int j=0; j < layer.size()-1; j++){
                sum+= layer.get(j);
                if(crack.containsKey(sum))
                    crack.put(sum, crack.get(sum) +1);
                else
                    crack.put(sum,1);
                max = Math.max(max, crack.get(sum));
            }
        }
        return wall.size() -max;
    }
}