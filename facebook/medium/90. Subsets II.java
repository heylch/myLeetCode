//itineration
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return result;
        int prevLen = 0;
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int i=0; i < nums.length; i++){
            if(i==0 || nums[i] != nums[i-1]){
                prevLen = result.size();
                for(int j=0; j < prevLen; j++){
                    List<Integer> list = new ArrayList<Integer>(result.get(j));
                    list.add(nums[i]);
                    result.add(list);
                }
            }
            else{
                int curLen = result.size();
                for(int j=prevLen; j < curLen; j++){
                    List<Integer> list = new ArrayList<Integer>(result.get(j));
                    list.add(nums[i]);
                    result.add(list);
                }
                prevLen = curLen;
            }
        }
        return result;
    }
}

//recursion
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        res.add(subset);
        doSubsets(nums,res,subset,0);
        return res;
    }
    
    private void doSubsets(int[] nums, List res,List subset,int start){
        if(start != nums.length){
            for(int i=start; i<nums.length; i++){
                subset.add(nums[i]);
                res.add(new ArrayList(subset));
                doSubsets(nums,res,subset,i+1);
                subset.remove(subset.get(subset.size()-1));
                while(i+1 < nums.length && nums[i] == nums[i+1])
                    i++;
            }
        }
    }
}