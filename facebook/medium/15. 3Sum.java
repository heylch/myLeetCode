// Sort O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
}

// without sort O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Set<Integer> check = new HashSet<Integer>();
        for(int i=0; i< num.length-2; i++){
            if(!check.contains(num[i])){
                Set<Integer> set = new HashSet<Integer>();
                for(int j=i+1; j < num.length; j++){
                    if(set.contains(0-num[i]-num[j]) && !check.contains(0-num[i]-num[j]) && !check.contains(num[j])){
                        result.add(Arrays.asList(num[i],0-num[i]-num[j],num[j]));
                    }
                    else
                        set.add(num[j]);
                }
                check.add(num[i]);
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>(result);
        return res;
    }
}