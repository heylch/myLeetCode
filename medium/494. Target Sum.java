class Solution {

    /////////////////////////Recursive  DFS O(2^n)//////////////////////////////////
    public int findTargetSumWays(int[] nums, int S) {
        int result =0;
        result = helper(0, nums, S, result);
        return result;
    }
    
    private int helper(int i, int[] nums, int S, int result){
        if(i== nums.length && S ==0){
            result += 1;
            return result;
        }
        else if(i >= nums.length)
            return result;
        result = helper(i+1, nums, S + nums[i],result);
        result = helper(i+1, nums, S - nums[i],result);
        return result;
        
    }

    /////////////////////DP O(n^2)//////////////////////////////////
    public int findTargetSumWays(int[] nums, int S){
        int sum =0;
        for(int num: nums)
            sum += num;
        if(S > sum || S < -sum)
            return 0;
        int[][] dp = new int[nums.length+1][2*sum+1];
        dp[0][sum] = 1;
        for(int i=0; i < nums.length; i++){
            for(int j= 0; j < 2*sum+1; j++){
                if(dp[i][j] !=0){
                    dp[i+1][j+nums[i]] += dp[i][j];
                    dp[i+1][j-nums[i]] += dp[i][j];
                }
            }
        }
        return dp[nums.length][S+sum];
    }
}