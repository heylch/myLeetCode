class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length ==0)
            return 0;
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        int maxLength = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            len[i] = 1;
            count[i] = 1;
            for(int j=0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(len[j]+1 > len[i]){
                        len[i] = len[j] +1;
                        count[i] = count[j];
                    }
                    else if(len[j]+1 == len[i])
                        count[i] += count[j];
                }
            }
            if(len[i] > maxLength){
                maxLength = len[i];
                result = count[i];
            }
            else if(len[i] == maxLength)
                result += count[i];
        }
        return result;
    }
}