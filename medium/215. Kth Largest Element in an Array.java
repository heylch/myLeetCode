class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> newNums = new ArrayList<Integer>();
        for(int i=0; i < nums.length; i++)
            newNums.add(nums[i]);
        k = newNums.size()-k+1;
        return LTS(newNums, k);
    }
    
    private int LTS(List<Integer> nums, int k){
        if(nums.size() < 5){
            Collections.sort(nums);
            return nums.get(k-1);
        }
        List<Integer> medians = new ArrayList<Integer>();
        for(int i=0; i <= nums.size()-5; i+=5){
            int[] five = new int[5];
            for(int j = 0; j< 5; j++)
                five[j] = nums.get(i+j);
            Arrays.sort(five);
            medians.add(five[2]);
        }
        int median = medians.size() ==1? medians.get(0) : LTS(medians, medians.size()/2);
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        List<Integer> middle = new ArrayList<Integer>();
        for(int i=0; i < nums.size(); i++){
            int num = nums.get(i);
            if(nums.get(i) < median)
                left.add(num);
            else if(nums.get(i) > median)
                right.add(num);
            else
                middle.add(num);
        }
        if(k >left.size() && k <= left.size() + middle.size())
            return median;
        else if(k <= left.size())
            return LTS(left, k);
        else
            return LTS(right, k - left.size() - middle.size());
    }
}