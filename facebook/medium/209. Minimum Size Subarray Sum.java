//O(n)
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int start=0;
        int end = 0;
        while(end < nums.length){
            while(end < nums.length && sum < s){
                sum += nums[end];
                end++;
            }
            System.out.println(end);
            if(sum < s && end == nums.length )
                break;
            while(start <= end && sum >= s){
                sum -= nums[start];
                start++;
            }
            System.out.println(start);
            result = Math.min(result,end - start+1);
        }
        result = (result == Integer.MAX_VALUE)? 0:result;
        return result;
    }
}


//O(nlgn)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        if (sums[nums.length - 1] < s) return 0;
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l)/2;
                if (sums[mid] - sums[i] + nums[i] == s) {
                    l = mid;
                    break;
                } else if (sums[mid] - sums[i] + nums[i] < s) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (l >= sums.length) break;
            ans = Math.min(ans, l - i + 1);
        }
        
        return (ans == Integer.MAX_VALUE ? 0 : ans);
    }
}