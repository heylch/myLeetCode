//O(n^2)     
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length ==0)
            return false;
        int[] dp = new int[nums.length+1];
        dp[0]= 0;
        for(int i =0; i < nums.length; i++){
            dp[i+1] = dp[i] + nums[i]; 
        }
        boolean result = false;
        for(int i = 2; i < dp.length; i++){
            for(int j=0; j < i -1; j++){
                if(k ==0){
                    if(dp[i] - dp[j]== 0)
                        return true;
                }
                else{
                    if((dp[i] - dp[j]) % k == 0)
                    return true;
                }
            }
        }
    }
}

//O(n)        
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length ==0)
            return false;
        Map<Integer, Integer> mod = new HashMap<Integer,Integer>();
        mod.put(0,-1);
        int sum =0;
        for(int i=0; i < nums.length; i++){
            sum+= nums[i];
            int module = (k==0)? sum:sum % k;
            if(mod.containsKey(module)){
                if(i-mod.get(module) > 1)
                    return true;
            }
            else
                mod.put(module,i);
        }
        return false;
    }
}