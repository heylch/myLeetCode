public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int start = 0;
        int end = nums.length-1;
        boolean flag = false;
        for(int i=0; i < nums.length-2; i++){
            int next = i +1;
            end = nums.length-1;
            while(next < end){
                if(nums[i] + nums[next] + nums[end] < target){
                    result += end - next;
                    next++;
                }
                else{
                   end--; 
                }
                
            }
        }
        return result;
    }