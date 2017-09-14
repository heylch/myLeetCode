class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        helper(nums, list, result, set);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result, Set<Integer> set){
        if(list.size() == nums.length){
            List<Integer> newList = new ArrayList<Integer>(list);
            result.add(newList);
            return;
        }
        else{
            for(int i= 0; i < nums.length; i++){
                if(!set.contains(i)){
                    list.add(nums[i]);
                    set.add(i);
                    List<Integer> newList = new ArrayList<Integer>(list);
                    helper(nums, newList, result, set);
                    list.remove(list.size()-1);
                    set.remove(i);
                    while(i+1 < nums.length && nums[i] == nums[i+1])
                        i++;
                }
            }
        }
    }
}