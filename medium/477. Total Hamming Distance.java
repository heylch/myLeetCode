class Solution {
    public int totalHammingDistance(int[] nums) {
        int result =0;
        for(int i = 0; i < 32; i++){
            int num0 = 0;
            int num1 = 0;
            for(int j =0;j < nums.length; j++){
                int digit = (nums[j] >> i) & 1;
                if(digit ==0)
                    num0++;
                else
                    num1++;
            }
            result += num0 * num1;
        }
        return result;
    }
}