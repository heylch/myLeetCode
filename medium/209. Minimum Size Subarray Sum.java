// My solution O(n) Two Pointers:
public int minSubArrayLen(int s, int[] nums) {
        Integer length = null;
        int sum = 0;
        int i = 0;
        int j = 0;
        while(i <= nums.length){
            while(j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            while(sum >= s){
                sum -= nums[i];
                i++;
            }
            if(j-i == nums.length && length == null)
                return 0;
            else if(j-i != nums.length && length == null)
                length = j-i+1;
            else 
                length = Math.min(length, j-i+1);
            if(j > nums.length-1)
                break;
        }
        return length;
    }

// O(nlgn) Binary Search Solution:
private int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
private int binarySearch(int lo, int hi, int key, int[] sums) {
    while (lo <= hi) {
       int mid = (lo + hi) / 2;
       if (sums[mid] >= key){
           hi = mid - 1;
       } else {
           lo = mid + 1;
       }
    }
    return lo;
}