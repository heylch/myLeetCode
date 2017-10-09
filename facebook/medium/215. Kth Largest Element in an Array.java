class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        return quickSelect(nums, 0, nums.length-1,k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k){
        if(start == end)
            return nums[start];
        int pivot = nums[start];
        int count = 0;
        int left = start+1;
        for(int i=start+1; i <=end; i++){
            if(nums[i] >= pivot){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
                count++;
            }
        }
        left--;
        int temp = nums[left];
        nums[left] = nums[start];
        nums[start] = temp;
        if(count == k-1)
            return nums[left];
        else if(count == 0)
            return quickSelect(nums,left+1,end,k-1);
        else if(count >=k)
            return quickSelect(nums,start,left-1,k);
        else
            return quickSelect(nums,left,end,k-count);
    }
}