class Solution {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        for(int i= 0; i < nums.length; i++){
            nums[length] = nums[i];
            length++;
            while(i+1 < nums.length && nums[i] == nums[i+1])
                i++;
        }
        return length;
    }
}