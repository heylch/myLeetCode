//iteration
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++){
            int len = result.size();
            for(int j=0; j < len; j++){
                List<Integer> list = new ArrayList<Integer>(result.get(j));
                list.add(nums[i]);
                result.add(list);
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
            }
        }
    }
}