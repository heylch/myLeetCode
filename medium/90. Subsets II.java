class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List <List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        Integer last = null;
        int start = 0;
        for(int i =0; i < nums.length; i++){
            int len = result.size();
            if(last == null || nums[i] != last){
                start = result.size();
                for(int j=0; j<len; j++){
                    List<Integer> list = result.get(j);
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(nums[i]);
                    result.add(newList);
                }
            }
            else{
                for(int j=start; j<len; j++){
                    List<Integer> list = result.get(j);
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(nums[i]);
                    result.add(newList);
                    }
                start = len;
            }
            last = nums[i];
        }
        return result;
    }
}