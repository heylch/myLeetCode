public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new <String>ArrayList();
        if (nums.length == 0){
            String range = "";
            if(lower == upper)
                range = lower+"";
            else
                range = lower+"->"+upper;
            result.add(range);
            return result;
        }
        int right = upper;
        for(int i = 0; i < nums.length; i++){
            if(i-1>=0 && nums[i] == nums[i-1]){
                while(i < nums.length && nums[i] == nums[i-1])
                    i++;
            }
            if(i == nums.length)
                break;
            if(nums[i] == lower)
                lower++;
            else{
                String range = "";
                if(nums[i] != lower+1){
                    range = lower+"->"+(nums[i]-1);
                }
                else
                    range = lower+"";
                result.add(range);
                lower = nums[i]+1;
            }
        }
        if(nums[nums.length-1] < upper){
            String range = "";
            if(nums[nums.length-1] +1 != upper){
                range = (nums[nums.length-1] +1) +"->"+upper;
            }
            else
                range = (nums[nums.length-1] +1)+"";
            result.add(range);
        }
        return result;
    }

    // better answer in one pass:
    // public List<String> findMissingRanges(int[] A, int lower, int upper) {
    //     List<String> result = new ArrayList<String>();
    //     int pre = lower - 1;
    //     for(int i = 0 ; i <= A.length  ; i++){
    //         int after = i == A.length ? upper + 1 : A[i]; 
    //         if(pre + 2 == after){
    //             result.add(String.valueOf(pre + 1));
    //         }else if(pre + 2 < after){
    //             result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
    //         }
    //         pre = after;
    //     }
    //     return result;
    // }