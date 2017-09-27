class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 0)
            return 0;
        Map<Integer, Integer> subsum = new HashMap<Integer, Integer>();
        subsum.put(0,-1);
        int maxLen = 0;
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] ==0)
                sum -=1;
            else
                sum+=1;
            if(!subsum.containsKey(sum)){
                subsum.put(sum,i);
            }
            else{
                int index = subsum.get(sum);
                maxLen = Math.max(maxLen, i-index);
            }
        }
        return maxLen;
    }
}