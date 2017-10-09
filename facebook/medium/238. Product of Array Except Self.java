class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        boolean hasZero = false;
        long product = 1;
        int zeroNum = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] == 0){
                hasZero = true;
                zeroNum++;
            }
            else
                product *= nums[i];
        }
        for(int i=0; i < nums.length; i++){
            if(zeroNum >=2)
                result[i] = 0;
            else if(nums[i] == 0)
                result[i] = (int)product;
            else{
                if(hasZero)
                    result[i] = 0;
                else
                    result[i] = (int)(product/nums[i]);
            }
        }
        return result;
    }
}