// two pass
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i=0; i < nums.length; i++)
            count[nums[i]]++;
        int index = 0;
        for(int i=0; i <3; i++){
            for(int j =0; j < count[i]; j++){
                nums[index] = i;
                index++;
            }
        }
    }
}

// one pass
class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length-1;
        for(int i = 0; i <= blue; i++){
            if(nums[i] == 0){
                int temp = nums[red];
                nums[red] = 0;
                nums[i] = temp;
                red++;
            }
            else if(nums[i] == 2){
                int temp = nums[blue];
                nums[blue] = 2;
                nums[i] = temp;
                i--;
                blue--;
            }
        }
    }
}