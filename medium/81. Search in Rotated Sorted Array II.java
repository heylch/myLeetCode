public boolean search(int[] nums, int target) {
        int start =0;
        int end = nums.length;
        boolean result = false;
        while(start < end){
            int mid=(start + end )/2;
            if(nums[mid]==target) 
                return true;
            if(nums[mid] > nums[end-1]){
                if(nums[mid] > target && nums[start] <= target) 
                    end = mid;
                else 
                    start = mid + 1;
            }
            else if(nums[mid] < nums[end-1]){
                if(nums[mid] < target && nums[end-1] >= target) 
                    start = mid + 1;
                else 
                    end = mid;
            }
            else{
                end--;
            }
        }
        return result;
    }