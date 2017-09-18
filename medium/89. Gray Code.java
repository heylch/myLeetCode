class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for(int i = 0; i < n; i++){
            int len = result.size();
            int num = (int)Math.pow(2,i);
            for(int j = len-1; j >=0; j--)
                result.add(num+result.get(j));
        }
        return result;
    }
}