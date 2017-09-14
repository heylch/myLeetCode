class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0)
            return new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(0, target, candidates, list, result);
        return result;
    }
    
    private void helper(int start, int target, int[] candidates, List<Integer> list, List<List<Integer>> result){
        if(start == candidates.length && target < 0)
            return;
        else if(target == 0){
            List<Integer> newList = new ArrayList<Integer>(list);
            result.add(newList);
            return;
        }
        else{
            for(int i = start; i < candidates.length; i++){
                if(target- candidates[i] < 0)
                    return;
                list.add(candidates[i]);
                List<Integer> newList = new ArrayList<Integer>(list);
                helper(i+1, target- candidates[i], candidates, newList, result);
                list.remove(list.size()-1);
                while(i+1 < candidates.length && candidates[i+1] == candidates[i])
                    i++;
            }
        }
    }
}