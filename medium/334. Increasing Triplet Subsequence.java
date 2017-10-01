class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean result = false;
        int i =0;
        while(i+1 < nums.length && nums[i] >= nums[i+1])
            i++;
        int first = i;
        int second = i+1;
        i+=2;
        int probfirst = first;
        while(i < nums.length){
            if(nums[i] > nums[second])
                return true;
            else if(nums[i] < nums[second] && nums[i] > nums[first])
                second = i;
            else if(nums[i] < nums[probfirst])
                probfirst = i;
            else if(nums[i] > nums[probfirst]){
                first = probfirst;
                second = i;
            }
            i++;
        }
        return false;
    }
}